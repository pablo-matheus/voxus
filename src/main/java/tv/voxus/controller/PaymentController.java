package tv.voxus.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import tv.voxus.model.Payment;
import tv.voxus.repository.PaymentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@Transactional
@Controller
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET, name = "payment.list")
    public ModelAndView list() {

        return new ModelAndView("index")
                .addObject("payments", paymentRepository.findAll());

    }

    @RequestMapping(value = "register", method = RequestMethod.GET, name = "payment.register")
    public ModelAndView register(@ModelAttribute("payment") Payment payment) {

        return new ModelAndView("view/register");

    }

    @RequestMapping(value = "insert", method = RequestMethod.POST, name = "payment.insert")
    public ModelAndView insert(@Valid Payment payment, BindingResult result) {

        if (result.hasErrors()) {

            return new ModelAndView("view/register");

        }

        payment.setTax(payment.getValue() * 0.05);
        paymentRepository.save(payment);

        return new ModelAndView("redirect:/");

    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET, name = "payment.edit")
    public ModelAndView edit(@PathVariable("id") Integer id, Payment payment) {

        return new ModelAndView("view/edit")
                .addObject("payment", paymentRepository.findById(id));

    }

    @RequestMapping(value = "update", method = RequestMethod.POST, name = "payment.update")
    public ModelAndView update(@Valid Payment payment, BindingResult result) {

        if (result.hasErrors()) {

            return new ModelAndView("view/register");

        }

        payment.setTax(payment.getValue() * 0.05);
        paymentRepository.save(payment);

        return new ModelAndView("redirect:/");

    }

    @RequestMapping(value = "remove/{id}", method = RequestMethod.GET, name = "payment.remove")
    public ModelAndView remove(@PathVariable Integer id, Payment payment) {

        try {

            paymentRepository.deleteById(id);

        } catch (Exception e) {

            log.error("Error removing payment with id: " + id, e);

        }

        return new ModelAndView("redirect:/");

    }

    @RequestMapping(value = "import", method = RequestMethod.GET, name = "payment.import")
    public ModelAndView importFile() {

        return new ModelAndView("view/file");

    }

    //Upload de arquivos ainda não está funcionando
    @RequestMapping(value = "upload", method = RequestMethod.POST, name = "payment.upload")
    public ModelAndView uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("file");
        return new ModelAndView("view/file");

    }

}
