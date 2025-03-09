import { useState, useEffect } from 'react'
import './App.css'

function App() {

    const [message, setMessage] = useState('');

    useEffect(() => {
        fetch(('/post/hello'))
            .then((response) => response.text())
            .then((data) => setMessage(data))
            .catch((error) => console.error("Error fetching: ", error));
    }, []);

  return <>
      <div>
          <h1>Hello React! </h1>
          <p>{message}</p>
      </div>
  </>;
}

export default App
