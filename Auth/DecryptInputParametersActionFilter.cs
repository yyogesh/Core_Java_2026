using Microsoft.AspNetCore.Mvc.Filters;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Text;
using System.Linq;
using SEB.FPE.Security;
using System.Dynamic;

namespace SEB.FPE.CustomFilters
{
    public class DecryptInputParametersActionFilter : ActionFilterAttribute
    {

        public override void OnActionExecuting(ActionExecutingContext context)
        {
            // our code before action executes
            //AESEncryptDecrypt.DecryptStringAES(
            ///var param = context.ActionArguments.SingleOrDefault(p => p.Value is IEntity);


            //foreach (var argument in context.ActionArguments.Values.Where(v => v is T))
            //{
            //    T model = argument as T;
            //    // your logic
            //}

            var _requestHeaders = context.HttpContext.Request.Headers.ToList();
            var headers = context.HttpContext.Request.Headers;
            string MemberDecrypted = string.Empty;
            string OrganizationDecrypted = string.Empty;
            string PlansponserDecrypted = string.Empty;
            string PersonDecrypted = string.Empty;
            //string strMemberId ="0";
            //var re = context.HttpContext.Request;
            //var headers = re.Headers;


            // bool _memberId=  context.HttpContext.Request.Headers.TryGetValue("memberid", out var strMemberId);

            bool memberDecryptionAttempted = false;
            bool organizationDecryptionAttempted = false;
            bool plansponserDecryptionAttempted = false;
            bool personDecryptionAttempted = false;

            if (!String.IsNullOrEmpty(headers["memberid"]))
            {
                string tokenmemberid = headers["memberid"];
                MemberDecrypted = AESEncryptDecrypt.DecryptStringAES(tokenmemberid);
                memberDecryptionAttempted = true;
            }
            else
            {
                var memberidQuery = context.HttpContext.Request.Query["memberid"];
                MemberDecrypted = memberidQuery.HasValue ? memberidQuery.ToString() : string.Empty;
            }


            if (!String.IsNullOrEmpty(headers["organizationid"]))
            {
                string tokenorganizationid = headers["organizationid"];
                OrganizationDecrypted = AESEncryptDecrypt.DecryptStringAES(tokenorganizationid);
                organizationDecryptionAttempted = true;
            }
            else
            {
                var organizationidQuery = context.HttpContext.Request.Query["organizationid"];
                OrganizationDecrypted = organizationidQuery.HasValue ? organizationidQuery.ToString() : string.Empty;
            }


            if (!String.IsNullOrEmpty(headers["plansponserid"]))
            {
                string tokenplansponserid = headers["plansponserid"];
                PlansponserDecrypted = AESEncryptDecrypt.DecryptStringAES(tokenplansponserid);
                plansponserDecryptionAttempted = true;
            }
            else
            {
                var plansponseridQuery = context.HttpContext.Request.Query["plansponserid"];
                PlansponserDecrypted = plansponseridQuery.HasValue ? plansponseridQuery.ToString() : string.Empty;
            }

            if (!String.IsNullOrEmpty(headers["personid"]))
            {
                string tokenpersonid = headers["personid"];
                PersonDecrypted = AESEncryptDecrypt.DecryptStringAES(tokenpersonid);
                personDecryptionAttempted = true;
            }
            else
            {
                var personidQuery = context.HttpContext.Request.Query["personid"];
                PersonDecrypted = personidQuery.HasValue ? personidQuery.ToString() : string.Empty;
            }

            // Validate decrypted values - if decryption was attempted but failed (returned empty), return unauthorized
            // This prevents blank pages and indicates authentication/session issues requiring token refresh or re-login
            if ((memberDecryptionAttempted && string.IsNullOrWhiteSpace(MemberDecrypted)) ||
                (organizationDecryptionAttempted && string.IsNullOrWhiteSpace(OrganizationDecrypted)) ||
                (plansponserDecryptionAttempted && string.IsNullOrWhiteSpace(PlansponserDecrypted)) ||
                (personDecryptionAttempted && string.IsNullOrWhiteSpace(PersonDecrypted)))
            {
                // Decryption was attempted but failed - likely a session/authentication issue
                // Return unauthorized to force token refresh or redirect to login
                context.Result = new UnauthorizedObjectResult(new { 
                    message = "Session expired or invalid. Please refresh your token or login again.",
                    requiresAuth = true 
                });
                return;
            }




            //if (_memberId)
            //    MemberDecrypted = AESEncryptDecrypt.DecryptStringAES(strMemberId);

            //var stringArgs = context.ActionArguments.Where(pair => pair.Value is string).ToList();

            //foreach (var keyValue in stringArgs)
            //{
            //    string safeValue = MemberDecrypted; //((string)keyValue.Value).Replace("\'", "");
            //    context.ActionArguments[keyValue.Key] = safeValue;
            //}



            var _params = context.ActionDescriptor.Parameters;


            foreach (var _itemArg in context.ActionArguments.ToList())
            {
                //object data = _itemArg.Value;
                //string strKey = _itemArg.Key;

                //Dictionary<string, string> _dictionary = data.GetType().GetProperties()
                //                                        .ToDictionary(x => x.Name, x => x.GetValue(data)?.ToString() ?? "");
                if (_itemArg.Key.ToLower() == "memberid")
                {
                    //_itemArg.Value = MemberDecrypted;
                    // var safeValue = ((string)_itemArg.Value).Replace(_itemArg.Value, MemberDecrypted);
                    var memberidParam = _params.Where(x => x.Name.ToLower() == "memberid").FirstOrDefault();
                    if (memberidParam != null && !string.IsNullOrEmpty(MemberDecrypted) && MemberDecrypted!="0")
                    {
                        context.ActionArguments[_itemArg.Key] = ChangeType(MemberDecrypted, memberidParam.ParameterType);
                    }

                    //_itemArg.Value = MemberDecrypted;

                    //context.HttpContext.Items.Add("entity", entity);

                    // context.ActionArguments.Add(strKey, entity);
                }

                if (_itemArg.Key.ToLower() == "organizationid")
                {

                    var organizationParam = _params.Where(x => x.Name.ToLower() == "organizationid").FirstOrDefault();
                    if (organizationParam != null)
                    {
                        if (OrganizationDecrypted=="undefined")
                        {
                            context.ActionArguments[_itemArg.Key] = 0;
                        }
                        else
                        {
                            if (!string.IsNullOrEmpty(OrganizationDecrypted) && OrganizationDecrypted != "0")
                            {
                                context.ActionArguments[_itemArg.Key] = ChangeType(OrganizationDecrypted, organizationParam.ParameterType);
                            }
                                
                        }
                    }
                    
                }
                if (_itemArg.Key.ToLower() == "orgid")
                {
                    var orgParam = _params.Where(x => x.Name.ToLower() == "orgid").FirstOrDefault();
                    if (orgParam != null && !string.IsNullOrEmpty(OrganizationDecrypted) && OrganizationDecrypted != "0")
                    {
                        context.ActionArguments[_itemArg.Key] = ChangeType(OrganizationDecrypted, orgParam.ParameterType);
                    }
                }
                if (_itemArg.Key.ToLower() == "plansponserid")
                {
                    var plansponserParam = _params.Where(x => x.Name.ToLower() == "plansponserid").FirstOrDefault();
                    if (plansponserParam != null && !string.IsNullOrEmpty(PlansponserDecrypted) && PlansponserDecrypted != "0")
                    {
                        context.ActionArguments[_itemArg.Key] = ChangeType(PlansponserDecrypted, plansponserParam.ParameterType);
                    }
                       
                }
                if (_itemArg.Key.ToLower() == "personid")
                {
                    var personParam = _params.Where(x => x.Name.ToLower() == "personid").FirstOrDefault();
                    if (personParam != null && !string.IsNullOrEmpty(PersonDecrypted) && PersonDecrypted != "0")
                    {
                        context.ActionArguments[_itemArg.Key] = ChangeType(PersonDecrypted, personParam.ParameterType);
                    }  
                }
            }
            
            base.OnActionExecuting(context);


            // base.OnActionExecuting(context);

        }

        public static object ChangeType(object value, Type conversion)
        {
            var t = conversion;

            if (t.IsGenericType && t.GetGenericTypeDefinition().Equals(typeof(Nullable<>)))
            {
                if (value == null)
                {
                    return null;
                }

                t = Nullable.GetUnderlyingType(t);
            }

            return Convert.ChangeType(value, t);
        }


        public override void OnActionExecuted(ActionExecutedContext context)
        {
            // our code after action executes
        }

        private static dynamic DictionaryToObject(IDictionary<String, Object> dictionary)
        {
            var expandoObj = new ExpandoObject();
            var expandoObjCollection = (ICollection<KeyValuePair<String, Object>>)expandoObj;

            foreach (var keyValuePair in dictionary)
            {
                expandoObjCollection.Add(keyValuePair);
            }
            dynamic eoDynamic = expandoObj;
            return eoDynamic;
        }

        //private string GetHeaderValue(this HttpRequest request, string key)
        //{
        //    //return request.Headers.FirstOrDefault(x => x.Key == key).Value.FirstOrDefault();
        //  return request.Headers.FirstOrDefault(x => x.Key == key).Value.FirstOrDefault();
        //}

        //public static dynamic GetAllHeaders(this HttpRequest Request, string key)
        //{
        //    Dictionary<string, string> requestHeaders =
        //       new Dictionary<string, string>();

        //    var expandoObjDictionary = (ICollection<KeyValuePair<String, Object>>)
        //   //return Request.Headers.FirstOrDefault(x => x.Key == key).Value.FirstOrDefault();

        //    foreach (var header in Request.Headers)
        //    {
        //        requestHeaders.Add(header.Key, header.Value);
        //    }
        //    return requestHeaders;
        //}

       

    }
}