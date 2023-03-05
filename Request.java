// Дана строка sql-запроса "select * from students where ". 
// Сформируйте часть WHERE этого запроса, используя StringBuilder. 
// Данные для фильтрации приведены ниже в виде json строки. 
// Если значение null, то параметр не должен попадать в запрос. 
// Параметры для фильтрации: 
// {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}


import java.io.BufferedReader;
import java.io.FileReader;


public class Request {
    public static String fileReader() throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader("RequestFile.txt"));
        String str2;
        while ((str2 = br.readLine()) != null) {
            sb.append(str2).append(System.lineSeparator());
        }
        String str = sb.toString();
        br.close();
        return str;
    }

    public static String[] split(String str) {
        String str2 = str.replace("{", "")
                .replace("}", "")
                .replace(":", ", ")
                .replace("\"", "")
                .replace("\n", "");
        String[] newStr = str2.split(", ");
        return newStr;
    }

    public static void createRequest (String[] arr) {
        StringBuilder resultStr = new StringBuilder();
        String startStr = "SELECT * FROM students WHERE ";
        resultStr.append(startStr);
        
        for (int i = 0; i < arr.length; i+=2) {
            if (!arr[i+1].contains("null")) {
                resultStr.append(arr[i] + " = " + arr[i+1] + " AND ");
                }
            }
        resultStr.lastIndexOf(" AND ");
        resultStr.delete(resultStr.lastIndexOf(" AND "), resultStr.length());        
        System.out.println(resultStr);
    }
   
    public static void main(String[] args) throws Exception {
        String data = fileReader();
        String[] dataArray = split(data);
        createRequest(dataArray);
    }
}