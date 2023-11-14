import './App.css';
import Home from './Component/Home';
import { HOME } from './utility/Route';
import {BrowserRouter,Switch,Route} from 'react-router-dom'


function App() {
  return (
    <>
    <BrowserRouter>
    
      <Switch>

        <Route exact path = {HOME}>
            <Home/>

        </Route>



      </Switch>
    
    
    
    
    </BrowserRouter>
    
    
    </>
  
  );
}

export default App;
