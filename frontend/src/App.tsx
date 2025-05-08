import { Route, Routes } from "react-router-dom";
import RegisterUser from "./pages/RegisterUser";
import Profile from "./pages/profile/Profile";

function App() {
    return (
        <Routes>
            <Route path="/" element={<RegisterUser />} />
            <Route path="/profile" element={<Profile />} />
        </Routes>
    );
}

export default App;
