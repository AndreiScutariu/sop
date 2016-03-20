using System;
using TestClient.UserService;

namespace TestClient
{
    public class App
    {
        static void Main()
        {

            var userService = new UserServiceClient();

            var user = new userDto { name = "Andrei Scutariu", roles = new roleDto[0] };
            
            var savedUserId = userService.add(user);
            Console.WriteLine("User added with id: " + savedUserId);

            var userToUpdate = userService.get(savedUserId);
            Console.WriteLine("Saved user: " + userToUpdate.name);
            userToUpdate.name = userToUpdate.name + " Modified";
            userService.update(savedUserId, userToUpdate);

            var updatedUser = userService.get(savedUserId);
            Console.WriteLine("Updated user: " + updatedUser.name);

            userService.delete(savedUserId);
            var deletedUser = userService.get(savedUserId);
            if (deletedUser == null)
            {
                Console.WriteLine("User with id {0} was deleted.", savedUserId);
            }
        }
    }
}