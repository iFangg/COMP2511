package unsw.piazza;

import java.util.List;
import java.util.ArrayList;

/**
 * A thread in the Piazza forum.
 */
public class Thread {
    /**
     * Creates a new thread with a title and an initial first post.
     * The author of the first post at the time of thread creation is the owner of the thread.
     * The owner cannot change once the thread is created.
     * @param title
     * @param firstPost
     */
    private User owner;
    private String title;
    private ArrayList<Post> posts = new ArrayList<Post>();
    private ArrayList<String> tags = new ArrayList<String>();
    public Thread(User owner, String title, Post firstPost) {
        this.owner = owner;
        this.title = title;
        this.posts.add(firstPost);
    }

    /**
     * @return The owner of the thread
     */
    public User getOwner() {
        return owner;
    }

    /**
     * @return The title of the thread
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return A SORTED list of unique tags
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     * @return A list of posts in this thread, in the order that they were published
     */
    public List<Post> getPosts() {
        return posts;
    }

    /**
     * Adds the given post object into the list of posts in the thread.
     * @param post
     */
    public void publishPost(Post post) {
        this.posts.add(post);
    }

    /**
     * Allows the given user to remove the Post from the thread.
     * Does nothing if the post is not in the thread.
     * @param post
     * @throws PermissionDeniedException if the given user is not an author of the post
     */
    public void removePost(Post post, User by) throws PermissionDeniedException {
    }

    /**
     * Allows the given uer to edit the thread title.
     * @param title
     * @param by
     * @throws PermissionDeniedException if the given user is not the owner of the thread.
     */
    public void setTitle(String title, User by) throws PermissionDeniedException {
    }

    /**
     * Allows the given user to replace the thread tags (list of strings)
     * @param tags
     * @param by
     * @throws PermissionDeniedException if the given user is not the owner of the thread.
     */
    public void setTags(String[] tags, User by) throws PermissionDeniedException {
    }
}
