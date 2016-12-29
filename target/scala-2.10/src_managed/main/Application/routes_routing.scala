// @SOURCE:/home/avirup/Downloads/placeFind-master/DbFramework/conf/Application.routes
// @HASH:ce5bcbf9e718f7364510044cf07d99934a1bff10
// @DATE:Thu Dec 29 18:59:41 IST 2016
package Application

import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String): Unit = {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_ApplicationController_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_ApplicationController_index0_invoker = createInvoker(
controllers.ApplicationController.index(),
HandlerDef(this.getClass.getClassLoader, "Application", "controllers.ApplicationController", "index", Nil,"GET", """shailesh""", Routes.prefix + """"""))
        

// @LINE:7
private[this] lazy val controllers_ApplicationController_signup1_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("signup"))))
private[this] lazy val controllers_ApplicationController_signup1_invoker = createInvoker(
controllers.ApplicationController.signup(),
HandlerDef(this.getClass.getClassLoader, "Application", "controllers.ApplicationController", "signup", Nil,"POST", """""", Routes.prefix + """signup"""))
        

// @LINE:8
private[this] lazy val controllers_ApplicationController_publishAnArticle2_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("publishAnArticle/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_ApplicationController_publishAnArticle2_invoker = createInvoker(
controllers.ApplicationController.publishAnArticle(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "Application", "controllers.ApplicationController", "publishAnArticle", Seq(classOf[String]),"POST", """""", Routes.prefix + """publishAnArticle/$id<[^/]+>"""))
        

// @LINE:10
private[this] lazy val controllers_ApplicationController_getUserArticles3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getUserArticles/"),DynamicPart("uid", """[^/]+""",true))))
private[this] lazy val controllers_ApplicationController_getUserArticles3_invoker = createInvoker(
controllers.ApplicationController.getUserArticles(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "Application", "controllers.ApplicationController", "getUserArticles", Seq(classOf[String]),"GET", """""", Routes.prefix + """getUserArticles/$uid<[^/]+>"""))
        

// @LINE:11
private[this] lazy val controllers_ApplicationController_getCategoryArticles4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getCategoryArticles/"),DynamicPart("category", """[^/]+""",true))))
private[this] lazy val controllers_ApplicationController_getCategoryArticles4_invoker = createInvoker(
controllers.ApplicationController.getCategoryArticles(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "Application", "controllers.ApplicationController", "getCategoryArticles", Seq(classOf[String]),"GET", """""", Routes.prefix + """getCategoryArticles/$category<[^/]+>"""))
        

// @LINE:12
private[this] lazy val controllers_ApplicationController_getAllTheUsers5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getAllTheUsers"))))
private[this] lazy val controllers_ApplicationController_getAllTheUsers5_invoker = createInvoker(
controllers.ApplicationController.getAllTheUsers(),
HandlerDef(this.getClass.getClassLoader, "Application", "controllers.ApplicationController", "getAllTheUsers", Nil,"GET", """""", Routes.prefix + """getAllTheUsers"""))
        

// @LINE:13
private[this] lazy val controllers_ApplicationController_getModifyCategoryOfArticle6_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getModifyCategoryOfArticle/"),DynamicPart("newCategory", """[^/]+""",true),StaticPart("/"),DynamicPart("articleID", """[^/]+""",true))))
private[this] lazy val controllers_ApplicationController_getModifyCategoryOfArticle6_invoker = createInvoker(
controllers.ApplicationController.getModifyCategoryOfArticle(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "Application", "controllers.ApplicationController", "getModifyCategoryOfArticle", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """getModifyCategoryOfArticle/$newCategory<[^/]+>/$articleID<[^/]+>"""))
        

// @LINE:14
private[this] lazy val controllers_ApplicationController_userProfile7_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("userProfile/"),DynamicPart("uid", """[^/]+""",true))))
private[this] lazy val controllers_ApplicationController_userProfile7_invoker = createInvoker(
controllers.ApplicationController.userProfile(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "Application", "controllers.ApplicationController", "userProfile", Seq(classOf[String]),"GET", """""", Routes.prefix + """userProfile/$uid<[^/]+>"""))
        

// @LINE:15
private[this] lazy val controllers_ApplicationController_removeArticle8_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("removeArticle/"),DynamicPart("articleid", """[^/]+""",true))))
private[this] lazy val controllers_ApplicationController_removeArticle8_invoker = createInvoker(
controllers.ApplicationController.removeArticle(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "Application", "controllers.ApplicationController", "removeArticle", Seq(classOf[String]),"GET", """""", Routes.prefix + """removeArticle/$articleid<[^/]+>"""))
        

// @LINE:16
private[this] lazy val controllers_ApplicationController_login9_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
private[this] lazy val controllers_ApplicationController_login9_invoker = createInvoker(
controllers.ApplicationController.login(),
HandlerDef(this.getClass.getClassLoader, "Application", "controllers.ApplicationController", "login", Nil,"POST", """""", Routes.prefix + """login"""))
        

// @LINE:17
private[this] lazy val controllers_ApplicationController_doLogout10_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
private[this] lazy val controllers_ApplicationController_doLogout10_invoker = createInvoker(
controllers.ApplicationController.doLogout(),
HandlerDef(this.getClass.getClassLoader, "Application", "controllers.ApplicationController", "doLogout", Nil,"GET", """""", Routes.prefix + """logout"""))
        

// @LINE:20
private[this] lazy val controllers_Assets_at11_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at11_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "Application", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.ApplicationController.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """signup""","""controllers.ApplicationController.signup()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """publishAnArticle/$id<[^/]+>""","""controllers.ApplicationController.publishAnArticle(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getUserArticles/$uid<[^/]+>""","""controllers.ApplicationController.getUserArticles(uid:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getCategoryArticles/$category<[^/]+>""","""controllers.ApplicationController.getCategoryArticles(category:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getAllTheUsers""","""controllers.ApplicationController.getAllTheUsers()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getModifyCategoryOfArticle/$newCategory<[^/]+>/$articleID<[^/]+>""","""controllers.ApplicationController.getModifyCategoryOfArticle(newCategory:String, articleID:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """userProfile/$uid<[^/]+>""","""controllers.ApplicationController.userProfile(uid:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """removeArticle/$articleid<[^/]+>""","""controllers.ApplicationController.removeArticle(articleid:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.ApplicationController.login()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.ApplicationController.doLogout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_ApplicationController_index0_route(params) => {
   call { 
        controllers_ApplicationController_index0_invoker.call(controllers.ApplicationController.index())
   }
}
        

// @LINE:7
case controllers_ApplicationController_signup1_route(params) => {
   call { 
        controllers_ApplicationController_signup1_invoker.call(controllers.ApplicationController.signup())
   }
}
        

// @LINE:8
case controllers_ApplicationController_publishAnArticle2_route(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ApplicationController_publishAnArticle2_invoker.call(controllers.ApplicationController.publishAnArticle(id))
   }
}
        

// @LINE:10
case controllers_ApplicationController_getUserArticles3_route(params) => {
   call(params.fromPath[String]("uid", None)) { (uid) =>
        controllers_ApplicationController_getUserArticles3_invoker.call(controllers.ApplicationController.getUserArticles(uid))
   }
}
        

// @LINE:11
case controllers_ApplicationController_getCategoryArticles4_route(params) => {
   call(params.fromPath[String]("category", None)) { (category) =>
        controllers_ApplicationController_getCategoryArticles4_invoker.call(controllers.ApplicationController.getCategoryArticles(category))
   }
}
        

// @LINE:12
case controllers_ApplicationController_getAllTheUsers5_route(params) => {
   call { 
        controllers_ApplicationController_getAllTheUsers5_invoker.call(controllers.ApplicationController.getAllTheUsers())
   }
}
        

// @LINE:13
case controllers_ApplicationController_getModifyCategoryOfArticle6_route(params) => {
   call(params.fromPath[String]("newCategory", None), params.fromPath[String]("articleID", None)) { (newCategory, articleID) =>
        controllers_ApplicationController_getModifyCategoryOfArticle6_invoker.call(controllers.ApplicationController.getModifyCategoryOfArticle(newCategory, articleID))
   }
}
        

// @LINE:14
case controllers_ApplicationController_userProfile7_route(params) => {
   call(params.fromPath[String]("uid", None)) { (uid) =>
        controllers_ApplicationController_userProfile7_invoker.call(controllers.ApplicationController.userProfile(uid))
   }
}
        

// @LINE:15
case controllers_ApplicationController_removeArticle8_route(params) => {
   call(params.fromPath[String]("articleid", None)) { (articleid) =>
        controllers_ApplicationController_removeArticle8_invoker.call(controllers.ApplicationController.removeArticle(articleid))
   }
}
        

// @LINE:16
case controllers_ApplicationController_login9_route(params) => {
   call { 
        controllers_ApplicationController_login9_invoker.call(controllers.ApplicationController.login())
   }
}
        

// @LINE:17
case controllers_ApplicationController_doLogout10_route(params) => {
   call { 
        controllers_ApplicationController_doLogout10_invoker.call(controllers.ApplicationController.doLogout())
   }
}
        

// @LINE:20
case controllers_Assets_at11_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at11_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     