import { Route, Routes } from "react-router-dom";
import RegisterUserPage from "./pages/RegisterUserPage";
import ProfilePage from "./pages/profile/ProfilePage";
import UserFeedPage from "./pages/feed/UserFeedPage";

function App() {
    return (
        <Routes>
            <Route path="/" element={<RegisterUserPage />} />
            <Route path="/profile" element={<ProfilePage />} />
            <Route path="/feed" element={<UserFeedPage />}></Route>
        </Routes>
    );
}

export default App;
