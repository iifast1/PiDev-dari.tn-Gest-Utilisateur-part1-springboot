using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;
using testinscri.Models;

namespace testinscri.Controllers
{
    public class UserController : Controller
    {
        // GET: UserController
        public ActionResult Index()
       
        {
            IEnumerable<User> users = null;
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080/");
                var responseTask = client.GetAsync("retrieve-all-users");
                responseTask.Wait();

                var result = responseTask.Result;
                if (result.IsSuccessStatusCode)
                {
                    var readJob = result.Content.ReadAsAsync<IList<User>>();
                    readJob.Wait();
                    users = readJob.Result;

                }
                else
                {
                    users = Enumerable.Empty<User>();
                }
            }
            return View(users);
        }

        // GET: UserController/Details/5
        public ActionResult Details(int iduser)
        {
            User users = null;

            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080/");
                var responseTask = client.GetAsync("retrieve-user/" + iduser.ToString());
                responseTask.Wait();

                var result = responseTask.Result;
                if (result.IsSuccessStatusCode)
                {
                    var readTask = result.Content.ReadAsAsync<User>();
                    readTask.Wait();

                    users = readTask.Result;
                }
            }
            return View(users);
        }


        // GET: UserController/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: UserController/Create
        [HttpPost]
        
        public ActionResult Create(User user)
        {
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080/register");
                var postJob = client.PostAsJsonAsync<User>("register", user);
                postJob.Wait();

                var postResult = postJob.Result;
                if (postResult.IsSuccessStatusCode)
                {
                    return RedirectToAction("Index");
                }
                return View(user);
            }
        }




        public ActionResult Delete(int iduser)
        {
            Console.WriteLine(iduser);
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080/");
                var deleteTask = client.DeleteAsync("remove-user/" + iduser.ToString());
                Console.WriteLine(iduser);
                var result = deleteTask.Result;
                if (result.IsSuccessStatusCode)
                {
                    return Redirect("/User/Index");
                }
                return Redirect("/User/Index");
            }
        }


        public ActionResult Edit(int id)
        {
           
            User users = null;
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080/");
                var responseTask = client.GetAsync("retrieve-user/" + id.ToString());
                responseTask.Wait();

                var result = responseTask.Result;
                if (result.IsSuccessStatusCode)
                {
                    var readTask = result.Content.ReadAsAsync<User>();
                    readTask.Wait();

                    users = readTask.Result;
                }
            }
            return View(users);
        }

        //craete post  method to update the data
        [HttpPost]
        public ActionResult Edit(User user)
        {

            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080/modify-user");
                var putTask = client.PutAsJsonAsync<User>("modify-user", user);
                putTask.Wait();

                var ressult = putTask.Result;
                if (ressult.IsSuccessStatusCode)

                    return Redirect("/User/Index");
                return View(user);

            }
        }
      


    }
}
