package com.lxy.util;

import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public final class Debugger{

    /**
     * Static Constants
     */
    public static int LEVEL_NONE= 0;  		//Trace off, no message is printed out
    public static int LEVEL_ALL = 5;  		//Trace all, all messages are printed out

    public static int LEVEL_CRITICAL = 1;   //Critical Error, such as connection to DB fail
    public static int LEVEL_ERROR = 2;      //Errors, such as unknown parameter value
    public static int LEVEL_WARNING = 3;    //Warning message, such as config file not found, 
                                     		//   use default values
    public static int LEVEL_INFO = 4;       //Some normal information, such as start time stamp
    public static int LEVEL_DEBUGGING = 5;  //Debugging message, report program defects
    private static int defaultLevel = 5;

    /**
     * Static Variables
     */
    static RandomAccessFile outFile = null;
    static SimpleDateFormat DateFormat = null;

    static int      traceLevel    = 0;
    static String   traceFileName = "msg_log.log";

    static boolean  bSystemOut    = false;
    static boolean  bFile         = false;

    /**
     *  Constructor
     */
    private Debugger(){}

    /**
     * To switch on/off Debugger
     * @param1 - flag
     */
    public static void setSystemOut( boolean flag ){
    	bSystemOut = flag;

    }

    /**
     * To log to the debug file
     * @param1 - flag
     */
    public static void setFileLog( boolean flag ){
    	bFile = flag;

    }

    /**
     * Setting the trace level to current level
     * @param1 - trace level
     */
    public static void setTraceLevel(int level) {
        traceLevel = level;
    }

    /**
     * Setting the default trace level to current level
     * @param1 - trace level
     */
    public static void setDefaultTraceLevel(int level) {
        defaultLevel = level;
    }
    /**
     * All of the above methods eventually call this   method
     * @param1 - message
     */
    private synchronized static void print( String line ){
		if (DateFormat == null)
			DateFormat = new SimpleDateFormat("dd/MMM HH:mm:ss.SSS: ");

		String d = DateFormat.format(new java.util.Date()) + line;

		if (bSystemOut)
			System.out.println(d);

		if (bFile) {
			try {
				if (outFile == null) {
					outFile = new RandomAccessFile(traceFileName, "rw");
					outFile.seek(outFile.length());
					outFile.writeBytes("\r\n------Logging Restarted--------------\r\n");
				}
				outFile.writeBytes(d + "\r\n");
			} catch (Exception E) {
			}
		}

    }

    /**
     * Print debugging message at the specified trace level
     * @param1 - in trace level
     * @param2 - String message
     */
    public static void println(int level, String msg ){
        if ( traceLevel < level )   return;
        String d = "ErrLevel=" + level + " "+ msg;
        print( d );
    }

    /**
     * Print debugging message using default trace level
     * @param msg - String message
     */

    public static void println(String msg ){
    	println( defaultLevel, msg );
    }
    
    /**
     * Print debugging message using default trace level
     * @param msg - StringBuffer message
     */

    public static void println(StringBuffer msg ){
    	println( defaultLevel, msg.toString() );
    }

    /**
     * Printing the stack trace
     * @param1 - int trace level
     * @param2 - Exception
     */
    public static void printStackTrace( int level, Exception e ){
    	e.printStackTrace();
        if( traceLevel < level ) return;

/*      ByteArrayOutputStream OS = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream( OS );
        System.setErr( ps );
        ps.print("trace level="+level +" ");
        e.printStackTrace();
        System.setErr( System.err );
        print( OS.toString() );
*/        
      	StringWriter str = new StringWriter();
      	PrintWriter ptr = new PrintWriter(str);
        ptr.print("ErrLevel="+level +" ");
      	e.printStackTrace(ptr);
        print( str.toString() );

    }

    /**
     * Printing the stack trace using default trace level
     * @param2 - Exception
     */
    public static void printStackTrace( Exception e ){
    	printStackTrace( LEVEL_ERROR, e );
    }


    /**
     * Initiate the trace logger
     * @param1 - dir name
     * @param2 - file name
     * @param3 - trace level
     */
    public static void initTraceLogger(String dir, String name, int level) {
        //Release old file object
        outFile = null;

        traceFileName = formatPathName( dir, name );
        traceLevel = level;

        File f = new File(traceFileName);
        //Check if the file exists and not empty
        if (f.exists() && f.length() > 0) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String timeStr = timestamp.toString();
            String time = timeStr.substring(8,10)+timeStr.substring(5,7)+"_"+timeStr.substring(11,13)+timeStr.substring(14,16);
            String bakFileName = traceFileName + time;
            renameFile( traceFileName, bakFileName );
        }
		setFileLog(true);
    }

  /**
   * Rename a source file to the destination file.
   * @param  fromFile  Original file to be renamed.
   * @param  toFile    Destination filename after the rename.
   * @return <code>true</code> if successful; <code>false</code> otherwise.
   */
    private static boolean renameFile(String fromFile, String toFile) {

        File from = new File(fromFile);
        File to = new File(toFile);

        if (from.exists()) {
            //Delete the backup file first if it exists
            if (to.exists()) {
                to.delete();
            }

            from.renameTo(to);

            return (true);
        } else {
            return (false);
        }
    }

  /**
    * Formats the directory name and a file name into a pathname.
    * @param  dir  Directory name
    * @param  file File name
    * @return a pathname
    */
    private static String formatPathName(String dir, String file) {
        if (dir.trim().length() == 0) {
          return (file);
        }
        else if (dir.trim().endsWith(System.getProperty("file.separator"))) {
          return (dir + file);
        }
        else {
          return (dir + System.getProperty("file.separator") + file);
        }
    }
}

