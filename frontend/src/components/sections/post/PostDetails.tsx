import styles from "./PostDetails.module.css";

const PostDetails = () => {
    return (
        <>
            <div className="max-w-4/6 gap-3" style={{ background: "aliceblue" }}>
                <div>
                    <div>Aditya Larma</div>
                    <div>
                        <div>
                            <p className={styles.customwrap}>"This is a test. This is a test. And this is a Test."</p>
                        </div>
                    </div>
                </div>
                <div>Like comment share options here</div>
            </div>
        </>
    );
};

export default PostDetails;
