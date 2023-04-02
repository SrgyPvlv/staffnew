import{P as n}from"./PositionsDataService-ef3b583a.js";import{_ as f,e as c,o as r,c as u,a as e,b as h,v as _,F as g,f as v}from"./index-2226a9a9.js";const w={name:"positions-list",data(){return{positions:[],newposition:""}},computed:{currentUser(){return this.$store.state.auth.user},showAdminBoard(){return this.currentUser&&this.currentUser.roles?this.currentUser.roles.includes("ROLE_ADMIN"):!1}},methods:{retrievePositions(){n.getAll().then(t=>{this.positions=t.data,console.log(t.data)}).catch(t=>{console.log(t)})},deletePosition(t){n.delete(t).then(s=>{console.log(s.data),this.refreshList()},s=>{s.response&&s.response.status===410&&c.dispatch("logout"),s.response&&s.response.status===404&&alert(`Ошибка!
Что-то пошло не так!
Возможно Вы пытаетесь удалить должность существующего сотрудника!?`)}).catch(s=>{console.log(s)})},editPosition(t,s){var p={position:s};n.update(t,p).then(o=>{console.log(o.data),this.refreshList()},o=>{o.response&&o.response.status===410&&c.dispatch("logout"),o.response&&o.response.status===501&&alert("Ошибка! Что-то пошло не так!")}).catch(o=>{console.log(o)})},createPosition(){var t={position:this.newposition};n.create(t).then(s=>{console.log(s.data),this.refreshList(),this.newposition=""},s=>{s.response&&s.response.status===410&&c.dispatch("logout"),s.response&&s.response.status===501&&alert("Ошибка! Что-то пошло не так!")}).catch(s=>{console.log(s)})},refreshList(){this.retrievePositions()}},mounted(){this.retrievePositions()}},b={class:"list row"},P={class:"col-md-8"},k=e("h3",null," Список должностей ",-1),L=e("label",{for:"newposition",class:"fw-bold fst-italic me-3"},"Новая должность",-1),U={class:"col-md-8 outdiv shadow mt-3"},x={class:"col-md-12 indiv"},B={class:"list-group list-group-flush"},C=["onUpdate:modelValue"],V=["onClick"],y=["onClick"];function A(t,s,p,o,l,a){return r(),u("div",b,[e("div",P,[k,L,h(e("input",{id:"newposition",name:"newposition",class:"newinputwidth","onUpdate:modelValue":s[0]||(s[0]=i=>l.newposition=i)},null,512),[[_,l.newposition]]),e("button",{onClick:s[1]||(s[1]=i=>a.createPosition()),class:"badge rounded-pill bg-info ms-3 border-0 delete"},"Создать"),e("div",U,[e("div",x,[e("ul",B,[(r(!0),u(g,null,v(l.positions,(i,m)=>(r(),u("li",{class:"list-group-item car",key:m},[h(e("input",{id:"position",name:"position",class:"inputwidth","onUpdate:modelValue":d=>i.position=d},null,8,C),[[_,i.position]]),e("button",{onClick:d=>a.editPosition(i.id,i.position),class:"badge rounded-pill bg-success ms-3 border-0 delete"},"Сохранить",8,V),e("button",{onClick:d=>a.deletePosition(i.id),class:"badge rounded-pill bg-danger ms-3 border-0 delete"},"Удалить",8,y)]))),128))])])])])])}const F=f(w,[["render",A]]);export{F as default};
