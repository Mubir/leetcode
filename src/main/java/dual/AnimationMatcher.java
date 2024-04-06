package dual;

import java.util.ArrayList;
import java.util.List;

public class AnimationMatcher {

    public static List<String> solution(String[] songs, String[] animations) {
        List<String> result = new ArrayList<>();

        for (String song : songs) {
            String[] songParts = song.split(":");
            String songName = songParts[0];
            int songLength = Integer.parseInt(songParts[1]);

            String selectedAnimation = null;
            int timesToBePlayed = Integer.MAX_VALUE;

            for (String animation : animations) {
                String[] animationParts = animation.split(":");
                String animationName = animationParts[0];
                int animationLength = Integer.parseInt(animationParts[1]);

                if (songLength >= animationLength && songLength % animationLength == 0) {
                    int currentTimesToBePlayed = songLength / animationLength;
                    if (currentTimesToBePlayed < timesToBePlayed) {
                        selectedAnimation = animationName;
                        timesToBePlayed = currentTimesToBePlayed;
                    }
                    break;
                }

            }

            result.add(selectedAnimation + ":" + timesToBePlayed);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] songs = {"notion:180", "voyage:185", "sample:180"};
        String[] animations = {"circles:360", "square:180", "lines:37"};
        List<String> result = solution(songs, animations);
        System.out.println(result); // Output: ["square:1", "lines:5", "square:1"]
    }
}

