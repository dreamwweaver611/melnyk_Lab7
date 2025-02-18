package Lab_7;


import java.util.ArrayList;
import java.util.Iterator;

class Videoblog {
    private String Videoblogger;
    private ArrayList<Video> Videos;
    public Videoblog(String Videoblogger, ArrayList<Video> Videos){
        this.Videoblogger = Videoblogger;
        this.Videos = Videos;
    }

    public ArrayList<Video> getVideos(){
        return Videos;
    }
}

class Video {
    private String name;
    private String URL;
    private int views_count;
    private int likes_count;
    private int dislikes_count;
    private ArrayList<Comment> Commentaries;
    public Video(String name, String URL, int views_count, int likes_count, int dislikes_count, ArrayList<Comment> Commentaries){
        this.name = name;
        this.URL = URL;
        this.views_count = views_count;
        this.likes_count = likes_count;
        this.dislikes_count = dislikes_count;
        this.Commentaries = Commentaries;
    }
    public int getLikes(){return likes_count; }
    public int getDislikes(){return dislikes_count; }
    public int getViews(){
        return views_count;
    }
    public String getName(){
        return name;
    }
    public ArrayList<Comment> getComment(){
        return Commentaries;
    }
}

class Comment {
    private String text;
    private int likes_count;
    private int dislikes_count;
    public Comment( String text, int likes_count, int dislikes_count){
        this.text = text;
        this.likes_count = likes_count;
        this.dislikes_count = dislikes_count;
    }
    public int getLikes(){ return likes_count;}
    public String getText(){ return text;}
}


public class Lab_7 {

    public static void main (String[] args){
        Comment comment1 = new Comment("1", 3, 1);
        Comment comment2 = new Comment("2", 2, 1);
        Comment comment3 = new Comment("3", 1, 1);
        Comment comment4 = new Comment("4", 7, 1);

        ArrayList<Comment> Commentaries1 = new ArrayList<Comment>();
        Commentaries1.add(comment1);
        Commentaries1.add(comment2);

        ArrayList<Comment> Commentaries2 = new ArrayList<Comment>();
        Commentaries2.add(comment3);
        Commentaries2.add(comment4);

        Video video1 = new Video("vid1","dgdgdg", 10, 4, 2, Commentaries1);

        Video video2 = new Video("vid2","dgdgdg", 20, 4, 2, Commentaries2);

        ArrayList<Video> Videos1 = new ArrayList<Video>();
        Videos1.add(video1);
        Videos1.add(video2);

        Videoblog videoblog = new Videoblog("111",Videos1);

        System.out.println(video_views_count(videoblog));

        System.out.println(comment_with_more_likes(videoblog));

        System.out.println(video_with_more_dislikes(videoblog));

    }

    public static int video_views_count(Videoblog blog){
        int cnt = 0;
        for(Iterator<Video> i = blog.getVideos().iterator(); i.hasNext();) {
            Video v = i.next();
            cnt+=v.getViews();
        }
        return cnt;
    }

    public static String comment_with_more_likes(Videoblog blog){

        String ans = null;

        for(Iterator i = blog.getVideos().iterator(); i.hasNext();) {
            Object v = i.next();

            if(v instanceof Video){
                Video video = (Video)v;

                for(Iterator j = video.getComment().iterator(); j.hasNext();) {

                    Object c = j.next();
                    if(c instanceof Comment){

                        Comment commment = (Comment) c;
                        if(video.getLikes()<commment.getLikes()){
                            ans = commment.getText();
                        }
                        else {
                            ans = "All video have more likes than comments";
                        }
                    }

                }
            }

        }
        return ans;
    }

    public static ArrayList <String> video_with_more_dislikes(Videoblog blog){
        Video mostDisVid = null;
        ArrayList <String> mostDisVidList = new ArrayList<String>();
        for(Video video:blog.getVideos()) {
            if(mostDisVid == null||mostDisVid.getDislikes()<video.getDislikes()){
                mostDisVidList.clear();
                mostDisVidList.add(video.getName());
                mostDisVid = video;
            }
            else if(mostDisVid.getDislikes()==video.getDislikes()){
                mostDisVidList.add(video.getName());
            }
        }
        return mostDisVidList;
    }
}
