const NewPost = () => {
    const handleNewPost = (e) => {
        console.log("Click Clieck Click!");
    };

    return (
        <>
            <div className="container">
                <form
                    onClick={(e) => {
                        e.preventDefault();
                    }}
                >
                    <div>
                        <textarea
                            style={{ width: "100%", resize: "none", border: "1px solid black" }}
                            name="new-post"
                            id="new-post"
                        ></textarea>
                    </div>
                    <div className="flex justify-end">
                        <button className="rounded-md w-20 bg-blue-400" type="submit" onClick={handleNewPost}>
                            Post
                        </button>
                    </div>
                </form>
            </div>
        </>
    );
};

export default NewPost;
