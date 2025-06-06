import UserDetails from "../../components/sections/user/UserDetails";
import type { Post } from "../../interfaces/Post";
import { fetchRequest } from "../../utils/RequestUtils";
import { useState, useEffect } from "react";

const ProfilePage = () => {
    const [posts, setPosts] = useState<Post[]>([]);

    useEffect(() => {
        const fetchPosts = async () => {
            const params = new URLSearchParams();

            params.append("user-id", "3203924224262144");

            const data = await fetchRequest("http://localhost:8833/pc/v1/posts?" + params.toString());

            setPosts(data);
        };
        
        fetchPosts();
    }, []);

    return (
        <>
            <div>
                <UserDetails />
            </div>
            <hr />
            {posts.map((post) => (
                <div key={post.id}>
                    <p>{post.details}</p>
                </div>
            ))}
        </>
    );
};

export default ProfilePage;
