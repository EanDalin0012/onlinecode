package com.onlinecode.admins.api;

import com.onlinecode.admins.services.implement.VendorServiceImplement;
import com.onlinecode.constants.Status;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import com.onlinecode.core.template.ResponseData;
import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/vendor")
public class VendorApi {
    private static final Logger log = LoggerFactory.getLogger(VendorApi.class);

    @Autowired
    private VendorServiceImplement vendorService;

    @GetMapping(value = "/list")
    public ResponseData<MultiMap> list () throws Exception {
        ResponseData<MultiMap> responseData = new ResponseData<>();
        try {
          log.info("\n\n<<<===****Start Vendor get list***====>>>\n\n");

          MMap input = new MMap();
          input.setString("status", Status.Active.getValueStr());

          MultiMap responseBody = vendorService.retrieveList(input);
          responseData.setBody(responseBody);

          log.info("\n\n<<<===****Vendor list value:"+responseData+"***====>>>\n\n");
          log.info("\n\n<<<===****End Vendor get list***====>>>\n\n");

        } catch (Exception e) {
            log.error("\n<<<=====get error api vendor get list=====>>>",e);
            throw  e;
        }
        return responseData;
    }

    @PostMapping(value = "/save")
    public ResponseData<MMap> save (@RequestParam("userId") int user_id, @RequestParam("lang") String lang, @RequestBody MMap param) throws Exception {
        ResponseData<MMap> responseData = new ResponseData<>();
        try {
            log.info("\n\n<<<===****Start Vendor save api***====>>>\n\n");

            MMap body = param.getMMap("body");

            log.info("\n\n<<<===****End Vendor save api param: "+body+"***====>>>\n\n");

            MMap input = new MMap();
            int id = vendorService.sequence();
            input.setInt("id",          id);
            input.setInt("user_id",     user_id);
            input.setString("name",     body.getString("name"));
            input.setString("contact",  body.getString("contact"));
            input.setString("email",    body.getString("email"));
            input.setString("description", body.getString("description"));
            input.setString("other_contact", body.getString("other_contact"));
            input.setString("address", body.getString("address"));
            input.setString("status", Status.Active.getValueStr());
            Long save = vendorService.save(input);

            MMap out = new MMap();
            out.setString("status", "N");
            if (save > 0 ) {
                out.setString("status", "Y");
            }
            responseData.setBody(out);

            log.info("\n\n<<<===****Vendor response : "+responseData+"***====>>>\n\n");
            log.info("\n\n<<<===****End Vendor save api***====>>>\n\n");

        } catch (Exception e) {
            log.error("\n\n<<<***===get error api vendor save exception***===>>>\n\n");
            throw e;
        }
        return responseData;
    }
}
