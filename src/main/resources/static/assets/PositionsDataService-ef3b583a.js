import{k as e}from"./index-2226a9a9.js";class o{get(t){return e.get(`/positions/${t}`)}getAll(){return e.get("/positions")}create(t){return e.post("/positions",t)}update(t,s){return e.put(`/positions/${t}`,s)}delete(t){return e.delete(`/positions/${t}`)}}const r=new o;export{r as P};
