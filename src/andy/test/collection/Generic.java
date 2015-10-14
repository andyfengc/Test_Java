package andy.test.collection;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Generic {
	public static void main(String[] args) {
		// 1
		List<FilterInputStream> list1 = new ArrayList<>();
		list1.add((FilterInputStream) null);
		list1.add((BufferedInputStream) null);
		// list1.add((InputStream)null);//error

		// 2
		List<? extends FilterInputStream> list11 = new ArrayList<FilterInputStream>();
		List<? extends FilterInputStream> list12 = new ArrayList<BufferedInputStream>();
		// List<? extends FilterInputStream> list13 = new
		// ArrayList<InputStream>();// error

		// 3
		List<? super FilterInputStream> list21 = new ArrayList<FilterInputStream>();
		// List<? super FilterInputStream> list22 = new
		// ArrayList<BufferedInputStream>();// error
		List<? super FilterInputStream> list23 = new ArrayList<InputStream>();
		list21.add((FilterInputStream) null);
		list21.add((BufferedInputStream) null);
		//list21.add((InputStream) null);//error
		
		// way4
		List<FilterInputStream> list31 = new ArrayList<FilterInputStream>();
		//List<FilterInputStream> list32 = new ArrayList<BufferedInputStream>();//error
		//List<FilterInputStream> list33 = new ArrayList<InputStream>();//error
		
	}
}
