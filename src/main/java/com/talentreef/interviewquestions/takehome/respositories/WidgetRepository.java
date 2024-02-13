package com.talentreef.interviewquestions.takehome.respositories;

import com.talentreef.interviewquestions.takehome.models.Widget;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class WidgetRepository {

  private static List<Widget> table = new ArrayList<>();

  public void deleteById(String name) {
    WidgetRepository.table = table.stream()
                                  .filter((Widget widget) -> !name.equals(widget.getName()))
                                  .toList();
  }

  public List<Widget> findAll() {
    return table;
  }

  public Optional<Widget> findById(String name) {
    Optional<Widget> result = table.stream()
                                   .filter((Widget widget) -> name.equals(widget.getName()))
                                   .findAny();
    return result;
  }

  public Widget save(Widget widget) {
    deleteById(widget.getName());
    table.add(widget);
    return widget;
  }

}
