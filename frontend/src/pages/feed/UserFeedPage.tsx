import NewPost from "../../components/sections/post/NewPost";
import PostDetails from "../../components/sections/post/PostDetails";

const UserFeedPage = () => {
    return (
        <div className="container mx-auto px-40">
            <div className="flex justify-center">
                <NewPost />
            </div>
            <div>
                <PostDetails />
            </div>
        </div>
    );
};

export default UserFeedPage;
