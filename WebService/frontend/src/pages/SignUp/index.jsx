export function SignUp() {
    const onChangeUsername = (event) =>{
        console.log(event)
    }
    return <>
        <h1>Sign Up</h1>
        <div>
            <label htmlFor={"username"}>Username</label>
            <input id={"username"} onChange={onChangeUsername}/>
        </div>
        <div>
            <label htmlFor={"email"}>Email</label>
            <input id={"email"}/>
        </div>
        <div>
            <label htmlFor={"password"}>Password</label>
            <input id={"password"} type={"password"}/>
        </div>
        <div>
            <label htmlFor={"passwordRepeat"}>Password Repeat</label>
            <input id={"passwordRepeat"} type={"password"}/>
        </div>
        <button>Sign Up</button>
    </>
}