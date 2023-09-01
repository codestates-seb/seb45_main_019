import { createGlobalStyle } from 'styled-components';

export const GlobalStyle = createGlobalStyle`
 :root {
    --main-width: 1264px;
    --main-height: calc(100vh - 382px);
    --orange : #EA862B;
    --blue : #0A95FF;
    --blue-hover : #0074CC;
    --sky-blue : #E1ECF4;
    --white: #ffffff;
    --white-10 : #f1f2f3;
    --black: #000000;
    --black-10: #0000001a;
    --black-50: #0000005a;
    --gray: #888888;
    --gray-10 : #D9D9D9;
    --gray-20 : #525960;
  }

  * {
      box-sizing: border-box;
      padding: 0;
      margin: 0;
      font-family: 'Noto Sans KR', 'Roboto', sans-serif;
      vertical-align: baseline;
      text-decoration: none;
    }

  body {
    min-height : 100vh;
    width: 100vw;
    overflow-x: hidden;
    /* overflow-y: scroll; */
  }

  ol, ul {
    list-style: none;
  }

  button {
    background: none;
    border: none;
    padding: 0;
    outline: none;
    cursor: pointer;
  }
`;
