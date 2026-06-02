import java.util.Arrays;

public class asteroids {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long currMass=mass;
        Arrays.sort(asteroids);
        for(int ast : asteroids){
            if(ast <= currMass){
                currMass = currMass+ast;
            }else {
                return false;
            }
            
        }
        return true;
        
    }
}