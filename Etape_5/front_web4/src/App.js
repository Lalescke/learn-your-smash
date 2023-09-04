import React, { useState } from "react";          //sate = component mémoire pour changer des éléments sans recharge de page
import { Routes, Route } from 'react-router-dom'; // React router = le gestionnaire des routes de l'app
import './App.css';

// Routes :
import Home from "./components/Home";
import Userlist from "./components/Userlist";
import User from "./components/User";
import Login from "./components/Login";
import Register from "./components/Register";

function App() {                        // Tout se passe dans le "App.js" => c'est ici qu'on ca afficher les components avec la synthaxe <component/>

  return (

    <div className="App">

      <Routes>
        <Route path="/" element={<Home />} />                   {/* Ici on dit que la route de base va être HOME, et c'est là qu'on va définir nos routes */}
        <Route path="/Userlist" element={<Userlist />} />                   {/* Deuxieme route qu'on ajoute => la liste des users */}
        <Route path="/User/:id" element={<User />} />                   {/* Route dynamique pour voir l'utilisateur à la place de ID */}
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
      </Routes>

    </div>
  );
}

export default App;


// Ajouter un bouton de déconnection qui n'apparait que si on est connecté, pour se déconnécter => fait automatiquement revenir à l'accueil