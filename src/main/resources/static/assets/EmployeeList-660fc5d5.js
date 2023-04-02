import{E as m}from"./EmployeesDataService-a0f50f70.js";import{D as g}from"./DepartmentsDataService-3555cd25.js";import{_ as v,e as E,r as b,o as i,c as u,a as e,w as D,b as f,v as S,d as y,F as p,f as a,t as o,g as h,h as c,i as w,j as B,n as k}from"./index-2226a9a9.js";const x={name:"employees-list",data(){return{employees:[],currentEmployee:null,currentIndex:-1,filter:"",factSelected:"Подразделение (факт)",staffSelected:"Подразделение (штат)",departments:[]}},computed:{birthdayBoys(){return this.employees.filter(l=>l.birthday!=null).filter(l=>new Date(l.birthday).getMonth()==new Date().getMonth()).sort((l,s)=>new Date(l.birthday).getDate()-new Date(s.birthday).getDate())},nextMonthBirthdayBoys(){return this.employees.filter(l=>l.birthday!=null).filter(l=>new Date(l.birthday).getMonth()==new Date().getMonth()+1).sort((l,s)=>new Date(l.birthday).getDate()-new Date(s.birthday).getDate())},currentUser(){return this.$store.state.auth.user},showAdminBoard(){return this.currentUser&&this.currentUser.roles?this.currentUser.roles.includes("ROLE_ADMIN"):!1},showSuperAdminBoard(){return this.currentUser&&this.currentUser.roles?this.currentUser.roles.includes("ROLE_SUPERADMIN"):!1}},methods:{retrieveEmployees(){m.getAll().then(l=>{this.employees=l.data,console.log(l.data)}).catch(l=>{console.log(l)})},refreshList(){this.retrieveEmployees(),this.currentEmployee=null,this.currentIndex=-1,this.filter="",this.factSelected="Подразделение (факт)",this.staffSelected="Подразделение (штат)"},deleteEmployee(){m.delete(this.currentEmployee.id).then(l=>{console.log(l.data),this.refreshList()},l=>{l.response&&l.response.status===410&&E.dispatch("logout"),l.response&&l.response.status===404&&alert("Ошибка! Что-то пошло не так!")}).catch(l=>{console.log(l)})},setActiveEmployee(l,s){this.currentEmployee=l,this.currentIndex=l?s:-1},findByNameMobilePosition(){m.findByNameMobilePosition(this.filter).then(l=>{this.employees=l.data,this.currentEmployee=null,this.currentIndex=-1,this.factSelected="Подразделение (факт)",this.staffSelected="Подразделение (штат)",console.log(l.data)}).catch(l=>{console.log(l)})},findByFactDepartment(){m.findByFactDivisionOrGroupeOrFunctionGroupOrderByNameAsc(this.factSelected).then(l=>{this.employees=l.data,this.currentEmployee=null,this.currentIndex=-1,this.staffSelected="Подразделение (штат)",console.log(l.data)}).catch(l=>{console.log(l)})},findByStaffDepartment(){m.findByStaffDivisionOrGroupeOrFunctionGroupOrderByNameAsc(this.staffSelected).then(l=>{this.employees=l.data,this.currentEmployee=null,this.currentIndex=-1,this.factSelected="Подразделение (факт)",console.log(l.data)}).catch(l=>{console.log(l)})},retrieveDepartments(){g.getAll().then(l=>{this.departments=l.data,console.log(l.data)}).catch(l=>{console.log(l)})}},mounted(){this.retrieveEmployees(),this.retrieveDepartments()}},M={class:"list row"},G={class:"col-md-8"},N={class:"input-group mb-3"},C={class:"input-group-append ms-2"},A={class:"input-group-append ms-3"},L={class:"input-group-append ms-3"},U={class:"dropdown"},I=e("button",{type:"button",class:"btn btn-outline-primary dropdown-toggle","data-bs-toggle":"dropdown"},"Подразделение",-1),P={class:"dropdown-menu customselect"},F=e("option",{disabled:"",style:{"font-weight":"bold"}},"Подразделение (факт)",-1),O=e("option",{disabled:"",style:{"font-weight":"bold"}},"Подразделение (штат)",-1),V={class:"list row"},R={class:"col-md-5"},j=e("h3",null," Список сотрудников ",-1),T={key:0,class:"text-primary"},z={key:1,class:"text-primary"},q={class:"col-md-12 outdiv shadow"},H={class:"col-md-12 indiv"},J={class:"list-group list-group-flush list-group-numbered"},K=["onClick"],Q={class:"col-md-4"},W={key:0},X=e("h3",null," Сотрудник ",-1),Y=e("label",null,[e("strong",null,"ФИО:")],-1),Z=e("label",null,[e("strong",null,"Должность:")],-1),$=e("label",null,[e("strong",null,"Подразделение (факт):")],-1),ee=e("label",null,[e("strong",null,"Подразделение (по штату):")],-1),te=e("label",null,[e("strong",null,"Мобильный телефон:")],-1),le=e("label",null,[e("strong",null,"Местный телефон:")],-1),ne=e("label",null,[e("strong",null,"Логин:")],-1),oe=e("label",null,[e("strong",null,"E-mail:")],-1),se=["href"],re=e("label",null,[e("strong",null,"Табельный номер:")],-1),ie=e("label",null,[e("strong",null,"Дата рождения:")],-1),ue=e("label",null,[e("strong",null,"Автомобиль:")],-1),ce=e("label",null,[e("strong",null,"Комментарий:")],-1),de={key:0},pe={key:1},me=e("br",null,null,-1),ae=e("p",null,"Выберите сотрудника...",-1),fe=[me,ae],he={class:"col-md-3 text-end"},ye={class:"col-md-12"},_e=e("h5",{class:"text-danger"},"Дни Рождения",-1),ge=e("h6",null,"В этом месяце",-1),ve=e("h6",null,"В следующем месяце",-1);function Ee(l,s,be,De,t,r){const _=b("RouterLink");return i(),u(p,null,[e("div",M,[e("div",G,[e("div",N,[e("form",{onSubmit:s[1]||(s[1]=D((...n)=>r.findByNameMobilePosition&&r.findByNameMobilePosition(...n),["prevent"]))},[f(e("input",{type:"text",class:"form-control inputform",placeholder:"Поиск по ФИО, мобильному, должности","onUpdate:modelValue":s[0]||(s[0]=n=>t.filter=n)},null,512),[[S,t.filter]])],32),e("div",C,[e("button",{type:"button",class:"btn btn-outline-secondary",onClick:s[2]||(s[2]=(...n)=>r.findByNameMobilePosition&&r.findByNameMobilePosition(...n))},"Поиск")]),e("div",A,[e("button",{type:"button",class:"btn btn-outline-danger",onClick:s[3]||(s[3]=(...n)=>r.refreshList&&r.refreshList(...n))},"Сбросить")]),e("div",L,[e("div",U,[I,e("ul",P,[e("li",null,[f(e("select",{class:"form-select",onChange:s[4]||(s[4]=(...n)=>r.findByFactDepartment&&r.findByFactDepartment(...n)),"onUpdate:modelValue":s[5]||(s[5]=n=>t.factSelected=n)},[F,(i(!0),u(p,null,a(t.departments,(n,d)=>(i(),u("option",{key:d},o(n.functionGroup!=null?n.functionGroup.functionGroup:n.groupe!=null?n.groupe.groupe:n.division.division),1))),128))],544),[[y,t.factSelected]])]),e("li",null,[f(e("select",{class:"form-select",onChange:s[6]||(s[6]=(...n)=>r.findByStaffDepartment&&r.findByStaffDepartment(...n)),"onUpdate:modelValue":s[7]||(s[7]=n=>t.staffSelected=n)},[O,(i(!0),u(p,null,a(t.departments,(n,d)=>(i(),u("option",{key:d},o(n.functionGroup!=null?n.functionGroup.functionGroup:n.groupe!=null?n.groupe.groupe:n.division.division),1))),128))],544),[[y,t.staffSelected]])])])])])])])]),e("div",V,[e("div",R,[j,t.factSelected!="Подразделение (факт)"?(i(),u("p",T,o(t.factSelected),1)):h("",!0),t.staffSelected!="Подразделение (штат)"?(i(),u("p",z,o(t.staffSelected),1)):h("",!0),e("div",q,[e("div",H,[e("ul",J,[(i(!0),u(p,null,a(t.employees,(n,d)=>(i(),u("li",{class:k(["list-group-item employee",{active:d==t.currentIndex}]),key:d,onClick:Se=>r.setActiveEmployee(n,d)},[c(o(n.name)+" ",1),e("sub",null,o(n.position.position),1)],10,K))),128))])])])]),e("div",Q,[t.currentEmployee?(i(),u("div",W,[X,e("div",null,[Y,c(" "+o(t.currentEmployee.name),1)]),e("div",null,[Z,c(" "+o(t.currentEmployee.position!=null?t.currentEmployee.position.position:""),1)]),e("div",null,[$,c(" "+o(t.currentEmployee.factDepartment!=null&t.currentEmployee.factDepartment.division!=null?t.currentEmployee.factDepartment.division.division:"")+" "+o(t.currentEmployee.factDepartment!=null&t.currentEmployee.factDepartment.groupe!=null?"/ "+t.currentEmployee.factDepartment.groupe.groupe:"")+" "+o(t.currentEmployee.factDepartment!=null&t.currentEmployee.factDepartment.functionGroup!=null?"/ "+t.currentEmployee.factDepartment.functionGroup.functionGroup:""),1)]),e("div",null,[ee,c(" "+o(t.currentEmployee.staffDepartment!=null&t.currentEmployee.staffDepartment.division!=null?t.currentEmployee.staffDepartment.division.division:"")+" "+o(t.currentEmployee.staffDepartment!=null&t.currentEmployee.staffDepartment.groupe!=null?"/ "+t.currentEmployee.staffDepartment.groupe.groupe:"")+" "+o(t.currentEmployee.staffDepartment!=null&t.currentEmployee.staffDepartment.functionGroup!=null?"/ "+t.currentEmployee.staffDepartment.functionGroup.functionGroup:""),1)]),e("div",null,[te,c(" "+o(t.currentEmployee.mobilePhone),1)]),e("div",null,[le,c(" "+o(t.currentEmployee.localPhone),1)]),e("div",null,[ne,c(" "+o(t.currentEmployee.login),1)]),e("div",null,[oe,c(),e("a",{href:`mailto:${t.currentEmployee.email}`},o(t.currentEmployee.email),9,se)]),e("div",null,[re,c(" "+o(t.currentEmployee.employeeId),1)]),e("div",null,[ie,c(" "+o(t.currentEmployee.birthday!=null?t.currentEmployee.birthday.split("-").reverse().join("."):""),1)]),e("div",null,[ue,c(" "+o(t.currentEmployee.car!=null?t.currentEmployee.car.carNumber:"")+" "+o(t.currentEmployee.car!=null?", "+t.currentEmployee.car.carModel.carModel:"")+" "+o(t.currentEmployee.car!=null?", ***Комментарий: "+t.currentEmployee.car.carComment:""),1)]),e("div",null,[ce,c(" "+o(t.currentEmployee.employeeComment),1)]),r.showAdminBoard||r.showSuperAdminBoard?(i(),u("div",de,[w(_,{to:"/employees/"+t.currentEmployee.id,class:"badge rounded-pill bg-info edit"},{default:B(()=>[c("Редактировать")]),_:1},8,["to"]),e("button",{onClick:s[8]||(s[8]=(...n)=>r.deleteEmployee&&r.deleteEmployee(...n)),class:"badge rounded-pill bg-danger ms-3 border-0 delete"},"Удалить")])):h("",!0)])):(i(),u("div",pe,fe))]),e("div",he,[e("div",ye,[_e,ge,e("ul",null,[(i(!0),u(p,null,a(r.birthdayBoys,(n,d)=>(i(),u("li",{key:d,class:"listyle"},o(n.name.split(" ")[0])+" "+o(n.name.split(" ")[1])+" "+o(n.birthday.split("-").reverse().join(".").slice(0,5)),1))),128))]),ve,e("ul",null,[(i(!0),u(p,null,a(r.nextMonthBirthdayBoys,(n,d)=>(i(),u("li",{key:d,class:"listyle"},o(n.name.split(" ")[0])+" "+o(n.name.split(" ")[1])+" "+o(n.birthday.split("-").reverse().join(".").slice(0,5)),1))),128))])])])])],64)}const xe=v(x,[["render",Ee]]);export{xe as default};
