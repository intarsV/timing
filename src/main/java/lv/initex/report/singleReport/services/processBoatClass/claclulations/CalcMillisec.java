package lv.initex.report.singleReport.services.processBoatClass.claclulations;

public  class CalcMillisec {

    public static long calcStartTimeMillis(String time) {
        String[] parts = time.split(":");
        long hours = Long.parseLong(parts[0]);
        long minutes = Long.parseLong(parts[1]);
        return (hours * 60 * 60 * 1000) + (minutes * 60 * 1000);
    }

    public static long calcSplitmillis(String time){
        String[] parts = time.split(":");
        long minutes = Long.parseLong(parts[0]);
        long seconds = Long.parseLong(parts[1]);
        return (minutes*60*1000)+(seconds*1000);
    }
}
