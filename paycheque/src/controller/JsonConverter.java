package controller;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONObject;

public class JsonConverter {

/////////////////json////////////////

public static ArrayList<JSONObject> getFormattedResult(ResultSet rs) {
ArrayList<JSONObject> resList = new ArrayList<JSONObject>();
try {
//get column names
ResultSetMetaData rsMeta = rs.getMetaData();
int columnCnt = rsMeta.getColumnCount();
ArrayList<String> columnNames = new ArrayList<String>();
for(int i=1;i<=columnCnt;i++) {
columnNames.add(rsMeta.getColumnName(i));
}

while(rs.next()) { // convert each object to an human readable JSON object
JSONObject obj = new JSONObject();
for(int i=1;i<=columnCnt;i++) {
String key = columnNames.get(i - 1);
String value = rs.getString(i);
obj.put(key, value);
}
resList.add(obj);
}
} catch(Exception e) {
e.printStackTrace();
} finally {
try {
rs.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
return resList;
}

	
	
}
