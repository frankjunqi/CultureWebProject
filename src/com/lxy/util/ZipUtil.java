package com.lxy.util;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

public class ZipUtil {
	private static Log log = LogFactory.getLog(ZipUtil.class);
	static final int BUFFER = 8192;
	
	public static void compress(String zipFile, String orgFile) throws Exception{
		try{
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile));
			out.setEncoding("GBK");
 
			File f = new File(orgFile);
			ZipUtil z = new ZipUtil();
			
			z.compress(f, out, "");
			out.close();
		}catch(Exception t){
			log.error(t);
			throw t;
		}
	}
	
	public static void main(String[] args) { 
		try{
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream("D:/test/FILE_PATH/册似乎.zip")); 
			out.setEncoding("GBK");
			File f = new File("D:/test/DOCUMENT_PATH");
			ZipUtil z = new ZipUtil();
			
			z.compress(f, out, "");
			out.close();
//			File srcdir = new File(orgFile);   
//			if (!srcdir.exists())   
//			    throw new RuntimeException(orgFile + "不存在！");   
//			   
//			Project prj = new Project();   
//			Zip zip = new Zip();   
//			zip.setProject(prj);   
//			zip.setDestFile(new File(zipFile));   
//			FileSet fileSet = new FileSet();   
//			fileSet.setProject(prj);   
//			fileSet.setDir(srcdir);   
//			//fileSet.setIncludes("**/*.java"); 包括哪些文件或文件夹 eg:zip.setIncludes("*.java");   
//			//fileSet.setExcludes(...); 排除哪些文件或文件夹   
//			zip.addFileset(fileSet);   
//			   
//			zip.execute();    

		}catch(Throwable t){
			t.printStackTrace();
		}
	}   

	/** 压缩一个文件 */  
	private void compressFile(File file, ZipOutputStream out, String basedir) {  
	    if (!file.exists()) {   
	        return;   
	    }   
	    try {   
	        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));   
	        ZipEntry entry = new ZipEntry(basedir + file.getName());   
	        out.putNextEntry(entry);   
	        int count;   
	        byte data[] = new byte[BUFFER];   
	        while ((count = bis.read(data, 0, BUFFER)) != -1) {   
	            out.write(data, 0, count);   
	        }   
	        bis.close();   
	    } catch (Exception e) {   
	        throw new RuntimeException(e);   
	    }
	}
	
	/** 压缩一个目录 */ 
	private void compressDirectory(File dir, ZipOutputStream out, String basedir) { 
	  if (!dir.exists()) 
	    return; 
	
	  File[] files = dir.listFiles(); 
	  for (int i = 0; i < files.length; i++) { 
	    /* 递归 */ 
	    compress(files[i], out, basedir + dir.getName() + "/"); 
	  } 
	} 
	
	private void compress(File file, ZipOutputStream out, String basedir) {
	    /* 判断是目录还是文件 */  
	    if (file.isDirectory()) {
	    	log.info("压缩目录：" + basedir + file.getName());
	        this.compressDirectory(file, out, basedir);
	    } else {
	    	log.info("压缩文件：" + basedir + file.getName());
	        this.compressFile(file, out, basedir);
	    }
	}
	
//	public static void main(String[] args) {  
//	    // TODO Auto-generated method stub   
//	    long startTime=System.currentTimeMillis();  
//	    try {  
//	        ZipInputStream Zin=new ZipInputStream(new FileInputStream(  
//	                "C:\\Users\\HAN\\Desktop\\stock\\SpectreCompressed.zip"));//输入源zip路径   
//	        BufferedInputStream Bin=new BufferedInputStream(Zin);  
//	        String Parent="C:\\Users\\HAN\\Desktop"; //输出路径（文件夹目录）   
//	        File Fout=null;  
//	        ZipEntry entry;  
//	        try {  
//	            while((entry = Zin.getNextEntry())!=null && !entry.isDirectory()){  
//	                Fout=new File(Parent,entry.getName());  
//	                if(!Fout.exists()){  
//	                    (new File(Fout.getParent())).mkdirs();  
//	                }  
//	                FileOutputStream out=new FileOutputStream(Fout);  
//	                BufferedOutputStream Bout=new BufferedOutputStream(out);  
//	                int b;  
//	                while((b=Bin.read())!=-1){  
//	                    Bout.write(b);  
//	                }  
//	                Bout.close();  
//	                out.close();  
//	                System.out.println(Fout+"解压成功");      
//	            }  
//	            Bin.close();  
//	            Zin.close();  
//	        } catch (IOException e) {  
//	            // TODO Auto-generated catch block   
//	            e.printStackTrace();  
//	        }  
//	    } catch (FileNotFoundException e) {  
//	        // TODO Auto-generated catch block   
//	        e.printStackTrace();  
//	    }  
//	    long endTime=System.currentTimeMillis();  
//	    System.out.println("耗费时间： "+(endTime-startTime)+" ms");  
//	}  

}  