import Link from "next/link";

export default function Login() {
  
  const formStyle = {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    justifyContent: 'center',
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    gap: '20px',
    background: 'rgba(255, 255, 255, 0.1)',
    boxShadow: '0 8px 32px 0 rgba(31, 38, 135, 0.37)',
    backdropFilter: 'blur(8.5px)',
    borderRadius: '20px',
    border: '1px solid rgba(255, 255, 255, 0.18)',
    padding: '40px',
    maxWidth: '400px',
  };

  const inputStyle = {
    width: '100%',
    padding: '15px',
    margin: '5px 0',
    display: 'inline-block',
    border: 'none',
    borderRadius: '20px',
    boxShadow: '0 4px 6px rgba(50, 50, 93, 0.11), 0 1px 3px rgba(0, 0, 0, 0.08)',
    background: 'rgba(255, 255, 255, 0.65)',
    backdropFilter: 'blur(4.5px)',
  };

  const buttonStyle = {
    width: '100%',
    padding: '15px',
    margin: '5px 0',
    border: 'none',
    borderRadius: '20px',
    cursor: 'pointer',
    background: 'linear-gradient(90deg, rgba(131,58,180,1) 0%, rgba(253,29,29,1) 50%, rgba(252,176,69,1) 100%)',
    color: 'white',
    fontSize: '16px',
  };

  return (
    <div style={formStyle}>
      <h2>Login</h2>
      <input style={inputStyle} type="text" placeholder="Username" />
      <input style={inputStyle} type="password" placeholder="Password" />
      <button style={buttonStyle}>Log In</button>
      <Link href="/signup">Don't have an account? Sign Up</Link>
    </div>
  );
}