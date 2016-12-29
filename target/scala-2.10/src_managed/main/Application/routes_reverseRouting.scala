// @SOURCE:/home/avirup/Downloads/placeFind-master/DbFramework/conf/Application.routes
// @HASH:ce5bcbf9e718f7364510044cf07d99934a1bff10
// @DATE:Thu Dec 29 18:59:41 IST 2016

import Application.Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplicationController {


// @LINE:12
def getAllTheUsers(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "getAllTheUsers")
}
                        

// @LINE:17
def doLogout(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                        

// @LINE:10
def getUserArticles(uid:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "getUserArticles/" + implicitly[PathBindable[String]].unbind("uid", dynamicString(uid)))
}
                        

// @LINE:14
def userProfile(uid:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "userProfile/" + implicitly[PathBindable[String]].unbind("uid", dynamicString(uid)))
}
                        

// @LINE:13
def getModifyCategoryOfArticle(newCategory:String, articleID:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "getModifyCategoryOfArticle/" + implicitly[PathBindable[String]].unbind("newCategory", dynamicString(newCategory)) + "/" + implicitly[PathBindable[String]].unbind("articleID", dynamicString(articleID)))
}
                        

// @LINE:8
def publishAnArticle(id:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "publishAnArticle/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:7
def signup(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "signup")
}
                        

// @LINE:11
def getCategoryArticles(category:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "getCategoryArticles/" + implicitly[PathBindable[String]].unbind("category", dynamicString(category)))
}
                        

// @LINE:15
def removeArticle(articleid:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "removeArticle/" + implicitly[PathBindable[String]].unbind("articleid", dynamicString(articleid)))
}
                        

// @LINE:6
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

// @LINE:16
def login(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                        

}
                          

// @LINE:20
class ReverseAssets {


// @LINE:20
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          
}
                  


// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplicationController {


// @LINE:12
def getAllTheUsers : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ApplicationController.getAllTheUsers",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllTheUsers"})
      }
   """
)
                        

// @LINE:17
def doLogout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ApplicationController.doLogout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:10
def getUserArticles : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ApplicationController.getUserArticles",
   """
      function(uid) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getUserArticles/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("uid", encodeURIComponent(uid))})
      }
   """
)
                        

// @LINE:14
def userProfile : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ApplicationController.userProfile",
   """
      function(uid) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "userProfile/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("uid", encodeURIComponent(uid))})
      }
   """
)
                        

// @LINE:13
def getModifyCategoryOfArticle : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ApplicationController.getModifyCategoryOfArticle",
   """
      function(newCategory,articleID) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getModifyCategoryOfArticle/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("newCategory", encodeURIComponent(newCategory)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("articleID", encodeURIComponent(articleID))})
      }
   """
)
                        

// @LINE:8
def publishAnArticle : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ApplicationController.publishAnArticle",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "publishAnArticle/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:7
def signup : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ApplicationController.signup",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "signup"})
      }
   """
)
                        

// @LINE:11
def getCategoryArticles : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ApplicationController.getCategoryArticles",
   """
      function(category) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getCategoryArticles/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("category", encodeURIComponent(category))})
      }
   """
)
                        

// @LINE:15
def removeArticle : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ApplicationController.removeArticle",
   """
      function(articleid) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "removeArticle/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("articleid", encodeURIComponent(articleid))})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ApplicationController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:16
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ApplicationController.login",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

}
              

// @LINE:20
class ReverseAssets {


// @LINE:20
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              
}
        


// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplicationController {


// @LINE:12
def getAllTheUsers(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ApplicationController.getAllTheUsers(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ApplicationController", "getAllTheUsers", Seq(), "GET", """""", _prefix + """getAllTheUsers""")
)
                      

// @LINE:17
def doLogout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ApplicationController.doLogout(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ApplicationController", "doLogout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:10
def getUserArticles(uid:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ApplicationController.getUserArticles(uid), HandlerDef(this.getClass.getClassLoader, "", "controllers.ApplicationController", "getUserArticles", Seq(classOf[String]), "GET", """""", _prefix + """getUserArticles/$uid<[^/]+>""")
)
                      

// @LINE:14
def userProfile(uid:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ApplicationController.userProfile(uid), HandlerDef(this.getClass.getClassLoader, "", "controllers.ApplicationController", "userProfile", Seq(classOf[String]), "GET", """""", _prefix + """userProfile/$uid<[^/]+>""")
)
                      

// @LINE:13
def getModifyCategoryOfArticle(newCategory:String, articleID:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ApplicationController.getModifyCategoryOfArticle(newCategory, articleID), HandlerDef(this.getClass.getClassLoader, "", "controllers.ApplicationController", "getModifyCategoryOfArticle", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """getModifyCategoryOfArticle/$newCategory<[^/]+>/$articleID<[^/]+>""")
)
                      

// @LINE:8
def publishAnArticle(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ApplicationController.publishAnArticle(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.ApplicationController", "publishAnArticle", Seq(classOf[String]), "POST", """""", _prefix + """publishAnArticle/$id<[^/]+>""")
)
                      

// @LINE:7
def signup(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ApplicationController.signup(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ApplicationController", "signup", Seq(), "POST", """""", _prefix + """signup""")
)
                      

// @LINE:11
def getCategoryArticles(category:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ApplicationController.getCategoryArticles(category), HandlerDef(this.getClass.getClassLoader, "", "controllers.ApplicationController", "getCategoryArticles", Seq(classOf[String]), "GET", """""", _prefix + """getCategoryArticles/$category<[^/]+>""")
)
                      

// @LINE:15
def removeArticle(articleid:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ApplicationController.removeArticle(articleid), HandlerDef(this.getClass.getClassLoader, "", "controllers.ApplicationController", "removeArticle", Seq(classOf[String]), "GET", """""", _prefix + """removeArticle/$articleid<[^/]+>""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ApplicationController.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ApplicationController", "index", Seq(), "GET", """shailesh""", _prefix + """""")
)
                      

// @LINE:16
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ApplicationController.login(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ApplicationController", "login", Seq(), "POST", """""", _prefix + """login""")
)
                      

}
                          

// @LINE:20
class ReverseAssets {


// @LINE:20
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          
}
        
    