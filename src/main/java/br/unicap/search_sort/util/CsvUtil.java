package br.unicap.search_sort.util;

import br.unicap.search_sort.entity.ResponseGenerate;
import br.unicap.search_sort.entity.ResponseSearchSort;

import java.io.*;
import java.util.List;

public class CsvUtil {
    private static final String CSV_SEPARATOR = ",";

    public static void exportResponses(String filename, List<ResponseSearchSort> responseEntityList) throws Exception {
            try
            {
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/java/br/unicap/search_sort/results/"+filename + ".csv"), "UTF-8"));

                StringBuffer oneLine = new StringBuffer();

                oneLine.append("Task");
                oneLine.append(CSV_SEPARATOR);
                oneLine.append("Algorithm");
                oneLine.append(CSV_SEPARATOR);
                oneLine.append("VectorSize");
                oneLine.append(CSV_SEPARATOR);
                oneLine.append("TimeExecution");
                oneLine.append(CSV_SEPARATOR);
                oneLine.append("NumberThreads");
                oneLine.append(CSV_SEPARATOR);
                oneLine.append("Status");

                bw.write(oneLine.toString());
                bw.newLine();

                for (ResponseSearchSort responseEntity : responseEntityList)
                {
                    oneLine = new StringBuffer();

                    oneLine.append(responseEntity.getTask());
                    oneLine.append(CSV_SEPARATOR);
                    oneLine.append(responseEntity.getAlgorithm().name());
                    oneLine.append(CSV_SEPARATOR);
                    oneLine.append(responseEntity.getVectorSize());
                    oneLine.append(CSV_SEPARATOR);
                    oneLine.append(responseEntity.getTimeExecution());
                    oneLine.append(CSV_SEPARATOR);
                    oneLine.append(responseEntity.getNumberThreads());
                    oneLine.append(CSV_SEPARATOR);
                    oneLine.append(responseEntity.getStatus());

                    bw.write(oneLine.toString());
                    bw.newLine();
                }
                bw.flush();
                bw.close();
            } catch (IOException e) {
                throw new Exception(e.getMessage());
            }

    }

    public static void exportResponsesGenerate(String filename, List<ResponseGenerate> responseEntityList) throws Exception {
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/java/br/unicap/search_sort/results/"+filename + ".csv"), "UTF-8"));

            StringBuffer oneLine = new StringBuffer();

            oneLine.append("Task");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("TimeExecution");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("VectorSize");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("Parallel");

            bw.write(oneLine.toString());
            bw.newLine();

            for (ResponseGenerate responseEntity : responseEntityList)
            {
                oneLine = new StringBuffer();

                oneLine.append(responseEntity.getTask());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(responseEntity.getTimeExecution());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(responseEntity.getVectorSize());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(responseEntity.getParallel());

                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new Exception(e.getMessage());
        }

    }
}
