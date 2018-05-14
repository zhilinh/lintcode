package systemdesign;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MiniCassandra {
	/**
	 * Definition of Column:
	 */
	 public class Column {
	     public int key;
	     public String value;
	     public Column(int key, String value) {
	         this.key = key;
	         this.value = value;
	    }
	 }
	 
	 public class ColumnComparator implements Comparator<Column> {

		@Override
		public int compare(Column o1, Column o2) {
			// TODO Auto-generated method stub
			return o1.key - o2.key;
		}
	 }
	 
	 Map<String, List<Column>> map;
	 
	 public MiniCassandra() {
		 // do initialization if necessary
		 map = new HashMap<String, List<Column>>();
	 }

	 /*
	  * @param raw_key: a string
	  * @param column_key: An integer
	  * @param column_value: a string
	  * @return: nothing
	  */
	 public void insert(String raw_key, int column_key, String column_value) {
	     // write your code here
		 if (!map.containsKey(raw_key)) {
			 map.put(raw_key, new ArrayList<Column>());
		 }
		 for (Column col : map.get(raw_key)) {
			 // UPDATE!
			 if (col.key == column_key) {
				 col.value = column_value;
				 return;
			 }
		 }
		 map.get(raw_key).add(new Column(column_key, column_value));
	 }

	 /*
	  * @param raw_key: a string
	  * @param column_start: An integer
	  * @param column_end: An integer
	  * @return: a list of Columns
	  */
	 public List<Column> query(String raw_key, int column_start, int column_end) {
	     // write your code here
		 List<Column> result = new ArrayList<Column>();
		 if (!map.containsKey(raw_key)) {
			 return result;
		 }
		 List<Column> columns = map.get(raw_key);
		 for (Column col : columns) {
			 if (column_start <= col.key && col.key <= column_end) {
				 result.add(col);
			 }
		 }
		 Collections.sort(result, new ColumnComparator());
		 return result;
	 }
}
