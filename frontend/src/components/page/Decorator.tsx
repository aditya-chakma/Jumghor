import type { ReactElement } from "react";
import Footer from "./Footer";
import Header from "./Header";
import PropTypes from "prop-types";

interface DecoratorProps {
    element: ReactElement;
}

const Decorator = ({ element }: DecoratorProps) => {
    return (
        <>
            <Header />
            {element}
            <Footer />
        </>
    );
};

Decorator.propTypes = {
    element: PropTypes.node.isRequired,
};

export default Decorator;
