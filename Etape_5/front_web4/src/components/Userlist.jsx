import React, { useState } from "react";

export default function Userlist() {

    const [userList, setUserList] = useState();

    fetch("http://localhost:8090/user/", {
        headers: { "Authorization": "Bearer " + sessionStorage.getItem('token') }
    })
        .then(res => res.json())
        .then(data => {
            setUserList(data)
        });



    return (
        <div className="Userlist">
            {JSON.stringify(userList)}
        </div>
    )
}
