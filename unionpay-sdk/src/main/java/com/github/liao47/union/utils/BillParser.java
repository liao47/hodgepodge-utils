package com.github.liao47.union.utils;

import com.github.liao47.common.exception.CustomException;
import com.github.liao47.union.model.BillDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.charset.Charset;

/**
 * 对账文件解析器
 * @author liao47
 * @date 2021/3/1 9:38
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BillParser {

    public interface Handler {
        /**
         * 处理对账文件行记录
         * @param billDTO
         * @param index
         */
        void handle(BillDTO billDTO, int index);

        /**
         * 找不到文件处理
         */
        default void handleFileNotFound() {
            //do nothing
        }
    }

    /**
     * 解析文件并插入记录
     * @param filePath
     * @param charset
     * @param handler
     */
    public static void parseFile(String filePath, Charset charset, Handler handler) {
        File file = new File(filePath);
        if (!file.exists() || file.isDirectory()) {
            log.warn("对账文件[{}]不存在或者是文件夹", filePath);
            handler.handleFileNotFound();
            throw new CustomException("银联对账文件不存在:" + filePath);
        }
        try (InputStreamReader read = new InputStreamReader(new FileInputStream(file), charset);
             BufferedReader bufferedReader = new BufferedReader(read)) {
            String lineData;
            int index = 1;
            while ((lineData = bufferedReader.readLine()) != null) {
                if (StringUtils.isNotBlank(lineData)) {
                    DataParser dataParser = DataParser.of(lineData);
                    if (dataParser == null) {
                        log.warn("数据不完整，忽略银联对账信息第[{}]行:[{}]", index, lineData);
                    } else {
                        handler.handle(dataParser.toBillDTO(), index++);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            log.error("获取对账文件[{}]失败:", filePath, e);
            handler.handleFileNotFound();
            throw new CustomException("获取对账文件失败");
        } catch (IOException e) {
            log.error("读取对账文件[{}]信息失败:", filePath, e);
            throw new CustomException("读取对账文件信息失败");
        }
    }

    /**
     * 行数据解析器
     */
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    private static class DataParser {
        private static final int[] LENGTH_ARR = {3, 11, 11, 6, 10, 19, 12, 4, 2, 21, 2, 32, 2, 6, 10, 13, 13, 4, 15, 2
                , 2, 6, 2, 4, 32, 1, 21, 15, 1, 15, 32, 13, 13, 8, 32, 13, 13, 12, 2, 1, 32, 13, 2, 1, 12, 67};

        /**
         * 行数据最小长度限制
         */
        private static final int MIN_LENGTH_LIMIT;
        static {
            int sum = 0;
            for (int length : LENGTH_ARR) {
                sum += length;
            }
            //每个值间有一个空格分隔，最后一个为保留值，可空
            sum += LENGTH_ARR.length - LENGTH_ARR[LENGTH_ARR.length - 1];
            MIN_LENGTH_LIMIT = sum;
        }

        /**
         * 行数据
         */
        private final String lineData;

        private int index;

        private int begin;

        public static DataParser of(String lineData) {
            if (lineData == null || lineData.length() < MIN_LENGTH_LIMIT) {
                return null;
            }
            return new DataParser(lineData, 0, 0);
        }

        private String next() {
            if (index >= LENGTH_ARR.length) {
                return null;
            }
            String data = lineData.substring(begin, Math.min(begin + LENGTH_ARR[index], lineData.length()));
            begin += LENGTH_ARR[index] + 1;
            index++;
            return data;
        }

        private String nextString() {
            return StringUtils.trim(this.next());
        }

        private Long nextLong() {
            String str = this.nextString();
            if (StringUtils.isEmpty(str)) {
                return null;
            }
            try {
                if (StringUtils.isAlphaSpace(String.valueOf(str.charAt(0)))) {
                    return Long.valueOf(str.substring(1));
                }
                return Long.valueOf(str);
            } catch (Exception e) {
                log.warn("Parse long failure[{}]:", str, e);
                return null;
            }
        }

        public BillDTO toBillDTO() {
            BillDTO billDTO = new BillDTO();
            billDTO.setTxnRespCode(nextString());
            billDTO.setAcqInsCode(nextString());
            billDTO.setSendInsCode(nextString());
            billDTO.setTraceNo(nextString());
            billDTO.setTxnTime(AcpUtils.parseDate(nextString()));
            billDTO.setPayCardNo(nextString());
            billDTO.setTxnAmt(nextLong());
            billDTO.setMerCatCode(nextString());
            billDTO.setTermType(nextString());
            billDTO.setQueryId(nextString());
            billDTO.setOldPayType(nextString());
            billDTO.setOrderId(nextString());
            billDTO.setPayCardType(nextString());
            billDTO.setOrigSysNo(nextString());
            billDTO.setOrigTxnTime(AcpUtils.parseDate(nextString()));
            billDTO.setFeeAmt(nextLong());
            billDTO.setSettleAmt(nextLong());
            billDTO.setPayType(nextString());
            billDTO.setGroupMerId(nextString());
            billDTO.setTxnType(nextString());
            billDTO.setTxnSubType(nextString());
            billDTO.setBizType(nextString());
            billDTO.setAccType(nextString());
            billDTO.setBillType(nextString());
            billDTO.setBillNo(nextString());
            billDTO.setInteractMode(nextString());
            billDTO.setOrigQryId(nextString());
            billDTO.setMerId(nextString());
            billDTO.setSplitAcctType(nextString());
            billDTO.setSubMerId(nextString());
            billDTO.setSubMerAbbr(nextString());
            billDTO.setSplitAcctAmt(nextLong());
            billDTO.setLiquidationNetAmt(nextLong());
            billDTO.setTermId(nextString());
            billDTO.setMerReserved(nextString());
            billDTO.setDiscountAmt(nextLong());
            billDTO.setInvoiceAmt(nextLong());
            billDTO.setInstalmentFee(nextLong());
            billDTO.setInstalmentCount(nextLong());
            billDTO.setTxnMedium(nextString());
            billDTO.setOrigOrderId(nextString());
            billDTO.setLiquidationAmt(nextLong());
            billDTO.setPoSentryModeCode(nextString());
            billDTO.setMobilePaySign(nextString());
            billDTO.setReferIndex(nextString());
            billDTO.setReserve(nextString());
            return billDTO;
        }
    }
}
