package com.jaronnie.springboot.controller;

import com.jaronnie.springboot.domain.bo.MachineBo;
import com.jaronnie.springboot.domain.bo.PageQuery;
import com.jaronnie.springboot.domain.vo.MachineStatisticsVo;
import com.jaronnie.springboot.domain.vo.MachineVo;
import com.jaronnie.springboot.domain.vo.TableDataInfo;
import com.jaronnie.springboot.service.IMachineService;
import com.jaronnie.springboot.util.R;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1.0/machine")
public class MachineController {
    private final IMachineService iMachineService;

    @GetMapping("/list")
    public R<TableDataInfo<MachineVo>> page(@ModelAttribute PageQuery pageQuery, @ModelAttribute MachineBo machineBo) {
        return R.ok(iMachineService.queryPageList(pageQuery, machineBo));
    }

    @GetMapping("/{id}")
    public R<MachineVo> detail(@PathVariable int id) {
        return R.ok(iMachineService.detail(id));
    }

    @PostMapping("/create")
    public R<Object> create(@Validated @RequestBody MachineBo machineBo) {
        return iMachineService.create(machineBo) ?
                R.ok("ok")
                :
                R.fail("create error");
    }

    @GetMapping("statistics")
    public R<List<MachineStatisticsVo>> statistics() {
        return R.ok(iMachineService.statistics());
    }
}
