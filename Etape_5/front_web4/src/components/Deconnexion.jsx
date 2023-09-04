import React from 'react';
import { useNavigate } from 'react-router-dom';

function Deconnexion() {

    const navigate = useNavigate();
    const handleButtonClick = (page) => {
        navigate(`/${page}`);
    };

    return (
        <button onClick={() => {
            sessionStorage.removeItem('token', 'username');
            window.location.reload();
        }}>Déconnexion</button>
    );
}

export default Deconnexion;