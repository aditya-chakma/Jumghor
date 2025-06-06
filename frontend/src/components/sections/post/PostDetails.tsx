import styles from "./PostDetails.module.css";
import type { Post } from "../../../interfaces/Post";

interface PostDetailsProps {
    post: Post;
}

const PostDetails = ({ post }: PostDetailsProps) => {
    const user = post.user;

    return (
        <div className={styles.postContainer}>
            <div className={styles.userName}>
                {user.displayName}
            </div>
            <div className={styles.postContent}>
                <p className={styles.postDetails}>{post.details}</p>
            </div>
            <div className={styles.postFooter}>
                <div className={styles.likes}>
                    {post.likes} likes
                </div>
                <a href="#" className={styles.commentsLink}>
                    View comments
                </a>
            </div>
        </div>
    );
};

export default PostDetails;
