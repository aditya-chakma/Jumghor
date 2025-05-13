import { Route, Routes } from "react-router-dom";
import RegisterUserPage from "./pages/RegisterUserPage";
import ProfilePage from "./pages/profile/ProfilePage";

function App() {
    return (
        <Routes>
            <Route path="/" element={<RegisterUserPage />} />
            <Route path="/profile" element={<ProfilePage />} />
        </Routes>
    );
}

export default App;
