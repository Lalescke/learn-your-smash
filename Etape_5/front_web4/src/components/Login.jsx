import React, { useState } from "react";           //sate = component mémoire pour changer des éléments sans recharge de page
import { Link, useLocation, useNavigate } from 'react-router-dom';



function Login() {

    const [username, setUsername] = useState('');               // stocker le username
    const [password, setPassword] = useState('');               // stocker le password
    const navigate = useNavigate();                             // Pour passer à la page login en cas de réussite


    const handleSubmit = (e) => {                                // utiliser les données qui sont entrées par les users = au début juste un console.log
        e.preventDefault();                                      // c'est le "e" entre parenthèses => il sert a prevent d'une erreur sans recharger la page et lose nos données ?

        // Requete de récupération de token/connection

        fetch("http://localhost:8090/authenticate", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'                // meme si il est déjà dit dans spring, il faut quand meme remettre le content-type ici ... alors que dans postman non bizarre
            },
            body: JSON.stringify({
                "username": username,
                "password": password
            })
        }).then((response) => {

            return response.json();                                 // c'est ça qu'il me manquait ! il fallait retourner un truc :')
        })
            .then(data => {
                if (data.token) {
                    console.log('Connexion réussie !');
                    sessionStorage.setItem('token', data.token);        // met le token en brut dans le sessionstorage 'token'
                    sessionStorage.setItem('username', username);
                    navigate('/');
                }
            })
            .catch(error => console.error(error));
    };


    return (
        <div>
            <h1>Login Page</h1>
            <form onSubmit={handleSubmit}>
                <label>
                    Username:
                    <input value={username} id="username" onChange={(e) => setUsername(e.target.value)} type="text" name="username" />
                </label>
                <label>
                    Password:
                    <input value={password} id="password" onChange={(e) => setPassword(e.target.value)} type="password" name="password" />
                </label>
                <button type="submit">Login</button>
            </form>
            <p>Pas de compte ? Booouh la honte : <Link to="/register">M'enregistrer</Link></p>
        </div>
    );
}

export default Login;

// Juste copié collé depuis le "Register"