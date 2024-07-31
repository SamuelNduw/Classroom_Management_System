public class IntStratItem {
    private int teacherID;
    private String stratDescription;
    IntStratItem(int teacherID, String stratDescription){
        this.teacherID = teacherID;
        this.stratDescription = stratDescription;
    }
    public String getStratDescription(){
        return stratDescription;
    }

}
