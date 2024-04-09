/* eslint-disable @typescript-eslint/no-explicit-any */
import { useContext, useState } from 'react';
import BookIcon from '../../../assets/img/logobook.png';
import './styles.css';
import { CredentialsDTO } from '../../../models/auth';
import * as authService from '../../../services/auth-service';
import { ContextToken } from '../../../utils/context-token';
import { useNavigate } from 'react-router-dom';

function Login() {

  const { setContextTokenPayload } = useContext(ContextToken)

  const navigate = useNavigate();

  const [formData, setformData] = useState<CredentialsDTO>({
    username: '',
    password: ''
  })

  function handleSubmit(event: any) {
    event.preventDefault();
    authService.LoginRequest(formData)
      .then(response => {
        authService.saveAccessToken(response.data.access_token);
        setContextTokenPayload(authService.getAccessTokenPayload());
        navigate("/cart")
      }).catch(error => {
        console.log("Erro no login", error)
      })
  }

  function handleInputChange(event: any) {
    const value = event.target.value;
    const name = event.target.name;
    setformData({ ...formData, [name]: value })
  }

  return (
    <div>
      <main>
        <section>
          <div className='container-login-form'>
            <form onSubmit={handleSubmit}>
              <div className='container-login-form-inside'>
                <div className='title-login-form'>
                  <h3>LOGIN</h3>
                  <img src={BookIcon} />
                </div>
                <div className="mb-3">
                  <label htmlFor="exampleInputEmail1" className="form-label">Email</label>
                  <input
                    type="email"
                    className="form-control"
                    name="username"
                    value={formData.username}
                    onChange={handleInputChange}
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="exampleInputPassword1" className="form-label">Password</label>
                  <input
                    type="password"
                    className="form-control"
                    name="password"
                    value={formData.password}
                    onChange={handleInputChange}
                  />
                </div>
                <div className="mb-3 form-check">
                  <input
                    type="checkbox"
                    className="form-check-input"
                    id="exampleCheck1"
                  />
                  <label className="form-check-label" htmlFor="exampleCheck1">Lembrar-me</label>
                </div>
                <div className="SignUpForgetPasswordContainer">
                  <p>Esqueci a senha</p>
                  <p>Cadastrar</p>
                </div>
                <button type="submit" className="btn-logar"> Logar</button>
              </div>
            </form>
          </div>
        </section>
      </main>
    </div >
  );
}

export default Login;
