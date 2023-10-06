package unsw.piazza;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

/**
 * A thread in the Piazza forum.
 */
public class Thread {
    /**
     * Creates a new thread with a title and an initial first post.
     * @param title
     * @param firstPost
     */
    private String title;
    // private String firstPost;
    private ArrayList<String> posts = new ArrayList<String>();
    private ArrayList<String> tags = new ArrayList<String>();
    public Thread(String title, String firstPost) {
        this.title = title;
        // this.firstPost = firstPost;
        this.posts.add(firstPost);
        // this.tags.add("test");
        // this.posts = new ArrayList<String>(firstPost);
    }

    /**
     * @return The title of the thread
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return A SORTED list of tags
     */
    public List<String> getTags() {
        // ArrayList<String> sorted = Collections.sort(tags);
        return tags;
    }

    /**
     * @return A list of posts in this thread, in the order that they were published
     */
    public List<String> getPosts() {
        return posts;
    }

    /**
     * Adds the given post object into the list of posts in the thread.
     * @param post
     */
    public void publishPost(String post) {
        this.posts.add(post);
    }

    /**
     * Allows the given user to replace the thread tags (list of strings)
     * @param tags
     */
    public void setTags(String[] tags) {
        ArrayList<String> tagList = new ArrayList<String>();
        for (String i: tags) {
            tagList.add(i);
        }
        Collections.sort(tagList);
        this.tags = tagList;
    }
}
