/* eslint-disable indent */
export const useValidation = (id?: string) => {
  switch (id) {
    case 'username':
      return (value: string) => {
        return value.length >= 5 && value.length < 20
          ? { valid: true, msg: '' }
          : { valid: false, msg: '5~20 글자 영소문자, 숫자' };
      };
    case 'nickname':
      return (value: string) => {
        return value.length >= 2 && value.length < 20
          ? { valid: true, msg: '' }
          : { valid: false, msg: '2~20 글자' };
      };
    case 'password':
      return (value: string) => {
        return value.length >= 8 && value.length < 20
          ? { valid: true, msg: '' }
          : { valid: false, msg: '8~20 글자 영문, 숫자, 특수문자 조합' };
      };
    case 'email':
      return (value: string) => {
        return value.length >= 2 && value.length < 20
          ? { valid: true, msg: '' }
          : { valid: false, msg: '올바른 이메일 형식이 아닙니다.' };
      };
    default:
      return () => {
        return { valid: true, msg: '' };
      };
  }
};
