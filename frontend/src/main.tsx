import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import App from "./App.tsx";
import { BrowserRouter } from "react-router-dom";
import Decorator from "./components/page/Decorator.tsx";

createRoot(document.getElementById("root")!).render(
    <StrictMode>
        <BrowserRouter>
            <Decorator element={<App />} />
        </BrowserRouter>
    </StrictMode>
);
