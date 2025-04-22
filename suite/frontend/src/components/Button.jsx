import { useEffect, useState } from "react";

function Button() {
    const [text, setText] = useState("");

    return (
        <>
            <span>
                <button>{text}</button>
            </span>
        </>
    );
}

export default Button;
