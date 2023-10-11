import styled, { createGlobalStyle } from 'styled-components';

export const GlobalStyle = createGlobalStyle`
  * {
      box-sizing: border-box;
      padding: 0;
      margin: 0;
      font-family: 'Noto Sans KR', 'Roboto', sans-serif;
      vertical-align: baseline;
      text-decoration: none;
    }

  body {
    min-height : 100%;
    width: 100vw;
    overflow-x: hidden;
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
  html{
    background-color: #f5f7fa;
  }
`;

export const GlobalContainer = styled.div`
  display: flex;
  width: 100%;
  min-height: calc(100vh - 70px);
  margin-top: 70px;
  background-color: #f5f7fa;
`;
