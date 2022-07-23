package Web.MBTIWebProject.controller;

import Web.MBTIWebProject.domain.Member;
import Web.MBTIWebProject.domain.Result;
import Web.MBTIWebProject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String crateForm(){
        return "members/createForm";
    }

    @PostMapping("/members/new")
    public String crate(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members/update")
    public String updateForm(){
        return "members/updateForm";
    }

    @PostMapping("/members/update")
    public String update(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        memberService.update(member, form.getRes());
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

    @GetMapping("/members/rank")
    public String rankForm(){
        return "members/rankForm";
    }
    @PostMapping("/members/rank")
    public String rank(MemberForm form, Model model){
        Member member = new Member();
        member.setName(form.getName());
        Result members = memberService.rank(member);
        model.addAttribute("members", members);
        return "members/result";
    }

    @PostMapping("/main")
    public String goMain(){return"members/main";}
}
