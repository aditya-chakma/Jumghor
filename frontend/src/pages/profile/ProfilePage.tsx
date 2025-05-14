import UserDetails from "../../components/sections/user/UserDetails";
import type { Post } from "../../interfaces/Post";
import { fetchRequest } from "../../utils/RequestUtils";

const ProfilePage = () => {
    const posts: Post[] = async () =>
        fetchRequest("http://localhost:8211/v1/p/all/{user_id}".replace("{user_id}", "1"));

    return (
        <>
            <div>
                <UserDetails />
            </div>
            {/* todo: Add posts */}
        </>
    );
};

export default ProfilePage;
